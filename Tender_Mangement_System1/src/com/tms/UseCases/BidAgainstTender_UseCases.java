package com.tms.UseCases;

import java.util.Scanner;

import com.tms.DAO.Bids_DAO;
import com.tms.DAO.Bids_DAO_Impl;
import com.tms.Exception.BidInsertException;

public class BidAgainstTender_UseCases {

	public static void bid_Against(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Offer Price:");
		int op = sc.nextInt();

		System.out.println("Enter Bid connection Id with respective Tender:");
		int bt = sc.nextInt();
		
		System.out.println("Enter Your Vendor Id:");
		int vi = sc.nextInt();
		
		Bids_DAO dao3 = new Bids_DAO_Impl();
		
		
		try {
			String results = dao3.bidAgainstTender(op, bt,vi, "Not Selected" );
			
			System.out.println(results);
			
			
		} catch (BidInsertException e) {
			
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
