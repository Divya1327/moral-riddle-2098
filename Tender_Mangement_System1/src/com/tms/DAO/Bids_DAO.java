package com.tms.DAO;

import java.util.List;

import com.tms.Exception.BidDetailsException;
import com.tms.Exception.BidInsertException;
import com.tms.bean.Bids;

public interface Bids_DAO {
	
	public String bidAgainstTender(int offerPrice, int bid_tender, int bid_vendor, String status)throws BidInsertException;
	
	public List<Bids> viewAllBidsOf_A_Tender(int bid_tender)throws BidDetailsException;

}
