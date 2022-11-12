package com.tms.UseCases;

import java.util.List;
import java.util.Scanner;

import com.tms.DAO.Bids_DAO;
import com.tms.DAO.Bids_DAO_Impl;
import com.tms.Exception.BidDetailsException;
import com.tms.bean.Bids;

public class ViewOwn_BidHistory_UseCases {
	
	public static void ViewOwn_BidHistory(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Your Vendor Id:");
		int yvi = sc.nextInt();
		
		Bids_DAO dao8 = new Bids_DAO_Impl();
		
		
		try {
			List<Bids> list7 = dao8.ViewOwnBidHistory(yvi);
			
			list7.forEach(s-> {
				
				System.out.println("Bid No.: "+s.getBid_no());
				System.out.println("Offer Price: "+s.getOfferPrice());
				System.out.println("Bid tender Id: "+s.getBid_tender());
				System.out.println("Bid Vendor Id: "+s.getBid_vendor());
				
				System.out.println("---------------------------");
				
			});
			
			
			
		} catch (BidDetailsException e) {
			
			System.out.println(e.getMessage());
		}
		sc.close();
		
	}

}
