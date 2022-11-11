package com.tms.UseCases;

import java.util.List;
import java.util.Scanner;

import com.tms.DAO.Bids_DAO;
import com.tms.DAO.Bids_DAO_Impl;
import com.tms.Exception.BidDetailsException;
import com.tms.bean.Bids;

public class ViewAll_Bids_UseCases {

	public static void ViewAll_Bids(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Bid connection Id with respective Tender:");
		int bt = sc.nextInt();
		
		Bids_DAO dao6 = new Bids_DAO_Impl();
		
		
		try {
			List<Bids> list5 = dao6.viewAllBidsOf_A_Tender(bt);
			
			System.out.println("\nList of all the Bids of a tender Id "+bt+" :");
			System.out.println("============================================");
			
			list5.forEach(s-> {
				
				System.out.println("Bid No.: "+s.getBid_no());
				System.out.println("Offer Price: "+s.getOfferPrice());
				System.out.println("Bid tender Id: "+s.getBid_tender());
				System.out.println("Bid Vendor Id: "+s.getBid_vendor());
				
				System.out.println("---------------------------");
				
			});
			
			
		} catch (BidDetailsException e) {
			
			System.out.println(e.getMessage());
		}

	}

}
