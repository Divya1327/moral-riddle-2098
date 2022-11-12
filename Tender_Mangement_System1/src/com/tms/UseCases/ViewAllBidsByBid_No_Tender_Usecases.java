package com.tms.UseCases;

import java.util.List;
import java.util.Scanner;

import com.tms.DAO.Bids_DAO;
import com.tms.DAO.Bids_DAO_Impl;
import com.tms.Exception.BidDetailsException;
import com.tms.bean.Bids;

public class ViewAllBidsByBid_No_Tender_Usecases {
	public static void ViewAllBidsByBid_No(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Bid No:");
		int br = sc.nextInt();
		
		System.out.println("Enter Bid connection Id with respective Tender:");
		int bt2 = sc.nextInt();
		
		Bids_DAO dao7 = new Bids_DAO_Impl();
		
		
		try {
			List<Bids> list6 = dao7.viewAllBidsByBid_No_Tender(br, bt2);
			
			list6.forEach(s-> {
				
				System.out.println("Bid No.: "+s.getBid_no());
				System.out.println("Offer Price: "+s.getOfferPrice());
				System.out.println("Bid tender Id: "+s.getBid_tender());
				System.out.println("Bid Vendor Id: "+s.getBid_vendor());
				System.out.println("Bid Status: "+s.getStatus());
				
				System.out.println("---------------------------");
				
			});
			
			
		} catch (BidDetailsException e) {
			
			System.out.println(e.getMessage());
		}
		sc.close();
		
	}

	}
