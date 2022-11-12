package com.tms.UseCases;

import java.util.List;
import java.util.Scanner;

import com.tms.DAO.Vendor_Tender_DAO;
import com.tms.Exception.TenderAssignedException;
import com.tms.bean.Vendor_Tender_DAO_Impl;
import com.tms.bean.Vendor_Tender_details;

public class Vendor_Tender_UseCases {

	public static void VenderTender(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Tender Id:");
		int vendor_id = sc.nextInt();
		
		
		Vendor_Tender_DAO dao7 = new Vendor_Tender_DAO_Impl();
		
		
		try {
			List<Vendor_Tender_details> list = dao7.viewAssignedDetails(vendor_id);
			
			System.out.println(" \nFull details of Assigned tender to a vendor as per T&C: ");
			System.out.println("==========================================================");
			
			list.forEach(s -> {
				
				System.out.println(" Vendor Id:------------- "+s.getId());
				System.out.println(" Vendor Name:----------- "+s.getVname());
				System.out.println(" Vendor GST No.:-------- "+s.getGst_no());
				System.out.println(" Vendor Establishment:-- "+s.getEdate());
				System.out.println(" Vendor Email:---------- "+s.getEmail());
				System.out.println(" Tender Id:------------- "+s.getTender_id());
				System.out.println(" Flat Type:------------- "+s.getFlat_type());
				System.out.println(" Furniture:------------- "+s.getFurniture());
				System.out.println(" Base Price:------------ "+s.getBase_price());
				System.out.println(" Highest Price Offered:- "+s.getHighest_offered_price());
				System.out.println(" Location:-------------- "+s.getLocation());
				System.out.println(" Start Date:------------ "+s.getS_date());
				System.out.println(" End Date:-------------- "+s.getE_date());
				
				System.out.println("--------/////-----------/////-------------");
				
				
			});
			
		} catch (TenderAssignedException e) {
			
			System.out.println(e.getMessage());
		}
		sc.close();
		
	}

}
