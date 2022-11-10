package com.tsm.UseCases;

import java.util.Scanner;

import com.tsm.DAO.Vendor_DAO;
import com.tsm.DAO.Vendor_DAO_Impl;

public class Login_Administrator_UseCases {

	public static void login(String[] args) {
		Scanner sc= new Scanner(System.in);
	
		System.out.println("Welcome to Admin login\n");
		
		System.out.println("Enter username:");
		String uname = sc.next();
		
		System.out.println("Enter password:");
		String pass = sc.next();
		
		Vendor_DAO dao = new Vendor_DAO_Impl();
		
		String r = dao.adminLogin(uname, pass);
		
		System.out.println(r);
		
		if(r.equalsIgnoreCase("Login Successful...")) {
		
			while(true) {
			System.out.println("\n1. Register new Vendor\n"
					+ "2. View all the Vendors\n"
					+"3. Create New Tenders\n"
					+"4. View all the Tenders\n"
					+"5. View All the Bids of a tender\n"
					+"6. Assign tender to a vendor\n"
					+"7. Exit\n");

	        }
		}
	
	}

}


