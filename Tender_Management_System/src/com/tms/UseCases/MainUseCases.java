package com.tms.UseCases;

import java.util.Scanner;

public class MainUseCases {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Welcome to Tender Management System");
		
		System.out.println(" 1. Administrator Signup\n"
				+" 2. Administrator Login\n"
				+ " 3. Vendor Login\n");
		
		try {
			System.out.println("Enter Choice:");
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				Administrator_Registration_UseCases.main(args);
				
				break;
			
		    case 2:
			     Login_Administrator_UseCases.login(args);
			
			   break;
			   
		    case 3:
		    	Vendor_Login_UseCases.vendor_Login(args);
		    	
		    	break;
		}
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
