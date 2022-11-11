package com.tms.UseCases;

import java.util.Scanner;

import com.tms.DAO.Vendor_DAO;
import com.tms.DAO.Vendor_DAO_Impl;

public class Login_Administrator_UseCases {

	public static void login(String[] args) {
		Scanner sc= new Scanner(System.in);
	
		System.out.println("Welcome to Admin login\n");
		
		System.out.println("Enter email:");
		String uname = sc.next();
		
		System.out.println("Enter password:");
		String pass = sc.next();
		
		Vendor_DAO dao = new Vendor_DAO_Impl();
		
		String r = dao.adminLogin(uname, pass);
		
		System.out.println(r);
		 if(r.equalsIgnoreCase("Login Successful...")) ;
		
	}

	}


