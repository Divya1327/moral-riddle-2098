package com.tms.UseCases;

import java.util.Scanner;

import com.tms.DAO.Vendor_DAO;
import com.tms.DAO.Vendor_DAO_Impl;
import com.tms.Exception.RegisterNewVendorException;

public class Register_Vendor_UseCases {

	public static void Vendor_Registor(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Vendor Name:");
		String vname = sc.next();
		
		System.out.println("Enter GST Number:");
		int gst_no = sc.nextInt();
		
		System.out.println("Enter Establishment Date(yyyy/mm/dd):");
		String edate = sc.next();
		
		System.out.println("Enter Vendor email:");
		String email = sc.next();
		
		System.out.println("Create Vendor password:");
		String password = sc.next();
		
		System.out.println("Enter Admin Id:");
		int admin_id = sc.nextInt();
		
		
		Vendor_DAO dao2 = new Vendor_DAO_Impl();
		
		
		try {
			String result = dao2.registerNewVendor(vname, gst_no, edate, email, password, admin_id);

			System.out.println(result);
			
			
		} catch (RegisterNewVendorException e) {
			
			System.out.println(e.getMessage());
		}
		
		

	}

}
