package com.tms.UseCases;

import java.util.Scanner;

import com.tms.DAO.Tenders_DAO;
import com.tms.DAO.Tenders_DAO_Iml;
import com.tms.Exception.TendersDetailsException;

public class Register_Tenders_UseCases {

	public static void Register_Tenders(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Tender Id:");
		int t_id = sc.nextInt();
		
		System.out.println("Enter flat Type (in BHK):");
		String f_t = sc.next();
		
		System.out.println("Enter Base Price:");
		int b_p = sc.nextInt();
		
		System.out.println("Enter Furniture Availability:\n"
								+"1. Available\n"
								+"2. Not Available\n");
		int avail = sc.nextInt();
		
		System.out.println("Enter Location:");
		String lc = sc.next();
		
		System.out.println("Enter Start Date(yyyy/mm/dd):");
		String s_d = sc.next();
		
		System.out.println("Enter End Date(yyyy/mm/dd):");
		String e_d = sc.next();
		

		String fr = "";
		
		if(avail == 1) {
			fr = "Available";
		}else if(avail == 2) {
			fr = "Not Available";
		}else {
			fr = "-----";
		}
		
		
		Tenders_DAO dao4 = new Tenders_DAO_Iml();
		
		
		try {
			String result2 = dao4.registerTenders(t_id, f_t+" BHK", b_p, fr, lc, s_d, e_d);
			
			System.out.println(result2);
			
			
		} catch (TendersDetailsException e) {

			System.out.println(e.getMessage());
		}
		
	}

}
