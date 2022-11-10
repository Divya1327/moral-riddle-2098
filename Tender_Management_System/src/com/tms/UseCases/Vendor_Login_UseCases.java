package com.tms.UseCases;

import java.util.Scanner;

import com.tms.DAO.Vendor_DAO;
import com.tms.DAO.Vendor_DAO_Impl;

public class Vendor_Login_UseCases {

	public static void vendor_Login(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to Vendor Login\n");
		
		System.out.println("Enter username:");
		String v_user = sc.next();
		
		System.out.println("Enter Password:");
		String v_pass = sc.next();
		
		Vendor_DAO dao2 = new Vendor_DAO_Impl();
		
		String result = dao2.adminLogin(v_user, v_pass);
		
		System.out.println(result);
		
		if(result.equalsIgnoreCase("Login Successful...")) {
			
			while(true) {
			System.out.println("\n1. View all the Tenders list\n"
								+"2. Place a Bid against a Tender\n"
								+"3. View status of a Bid(Whether Selected or Not)\n"
								+"4. View his own Bid History\n"
								+"5. Exit\n");

	        }
        }
		sc.close();
	}
}
