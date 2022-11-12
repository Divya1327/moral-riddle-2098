package com.tms.UseCases;

import java.util.Scanner;

import com.tms.DAO.Vendor_DAO;
import com.tms.DAO.Vendor_DAO_Impl;

public class Vendor_Login_UseCases {

	public static boolean vendor_Login(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Welcome to Admin login\n");
		
		System.out.println("Enter email:");
		String email = sc.next();
		
		System.out.println("Enter password:");
		String pass = sc.next();
		
		Vendor_DAO dao = new Vendor_DAO_Impl();
		
		String r = dao.vendorLogin(email, pass);

		if(r.equalsIgnoreCase("Login Successful...")) {
			System.out.println(r);
			return true;
		}else {
			return false;
		}
	}
}
