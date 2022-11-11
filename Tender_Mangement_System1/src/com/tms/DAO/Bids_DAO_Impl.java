package com.tms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tms.Exception.BidDetailsException;
import com.tms.Exception.BidInsertException;
import com.tms.Utility.DBUtility;
import com.tms.bean.Bids;

public class Bids_DAO_Impl implements Bids_DAO{

	@Override
	public String bidAgainstTender(int offerPrice, int bid_tender, int bid_vendor, String status)
			throws BidInsertException {
       String msg = "Not Inserted";
		
		try(Connection conn = DBUtility.provideTenderConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from bids where bid_tender = ? AND vendor_id = ?");
			
			ps.setInt(1, bid_tender);
			ps.setInt(2, bid_vendor);
			
			ResultSet rst = ps.executeQuery();
			
			if(rst.next()) {
				
				msg = "unable to bid again, you can bid only once against each tender...";
				
			}else {
				try(Connection conn11 = DBUtility.provideTenderConnection()) {
					
				PreparedStatement ps1 = conn11.prepareStatement("select count(bid_no) from bids group by bid_tender having bid_tender = ?");
					
				ps1.setInt(1, bid_tender);
					
				ResultSet rs1 = ps1.executeQuery();
					
				if(rs1.next()) {
						
				int count  = rs1.getInt("count(bid_no)");
						
				if(count < 3) {
							
				PreparedStatement ps2 = conn.prepareStatement("insert into bids(offer_price, bid_tender, vendor_id, status_of_bid) "
									+ "values(?,?,?,?)");
							
							ps2.setInt(1, offerPrice);
							ps2.setInt(2, bid_tender);
							ps2.setInt(3, bid_vendor);
							ps2.setString(4, status);
							
							int x = ps2.executeUpdate();
							if(x>0)
								msg = "Bid placed against tender successfully...\n";
							else
								throw new BidInsertException("Technical error...\n"+msg);
							
						}else {
							throw new BidInsertException("Bid limit Exceeded...\n"+msg);
						}
							
					}else {
						try(Connection conn1 = DBUtility.provideTenderConnection()){
							PreparedStatement ps3 = conn.prepareStatement("insert into bids(offer_price, bid_tender, vendor_id, status_of_bid) "
									+ "values(?,?,?,?)");
							
							ps3.setInt(1, offerPrice);
							ps3.setInt(2, bid_tender);
							ps3.setInt(3, bid_vendor);
							ps3.setString(4, status);
							
							int x = ps3.executeUpdate();
							
							if(x>0)
								status = "Bid placed against tender successfully...\n";
							else
								throw new BidInsertException("Technical error...\n"+msg);
							}catch (SQLException e) {
								throw new BidInsertException("Bid data error...\n"+msg);
							}
					}
					
				} catch (SQLException e) {
					throw new BidInsertException(e.getMessage());
				}
			}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public List<Bids> viewAllBidsOf_A_Tender(int bid_tender) throws BidDetailsException {
	  List<Bids> list = new ArrayList<>();
		
		try(Connection conn = DBUtility.provideTenderConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from bids where bid_tender = ?");
			
			ps.setInt(1, bid_tender);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int bi = rs.getInt("bid_no");
				int p = rs.getInt("offer_price");
				int bt = rs.getInt("bid_tender");
				int vi = rs.getInt("vendor_id");
				String st = rs.getString("status_of_bid");
				
				Bids bids = new Bids(bi, p, bt, vi, st);
				
				list.add(bids);
				
			}
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if(list.isEmpty())
			throw new BidDetailsException("List is empty...");
		
		
		return list;
	}

}
