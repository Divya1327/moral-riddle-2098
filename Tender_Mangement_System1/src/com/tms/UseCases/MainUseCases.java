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
						while(true) {
						System.out.println("\n1. Register new Vendor\n"
								+ "2. View all the Vendors\n"
								+"3. Create New Tenders\n"
								+"4. View all the Tenders\n"
								+"5. View All the Bids of a tender\n"
								+"6. Assign tender to a vendor\n"
								+"7. Exit\n");		
						
						System.out.println("Enter Choice:");
				    	int ch = sc.nextInt();
						switch(ch) {
						case 1:
							Register_Vendor_UseCases.Vendor_Registor(args);
							break;
						case 2:
							ViewAll_VendorsList_UseCases.View_Vendorlist(args);
						    break;
						case 3:
							Register_Tenders_Details_UserCases.Tender_Register(args);
							 break;
						case 4:
							ViewAll_Tenders_Details_UseCases.viewAllTenders(args);
							break;
						case 5:
							ViewAll_Bids_UseCases.ViewAll_Bids(args);
							
					}
			}
				
  
		    case 3:
		    	Vendor_Login_UseCases.vendor_Login(args);
		    	System.out.println("\n1. View all the Tenders list\n"
						+"2. Place a Bid against a Tender\n"
						+"3. View status of a Bid(Whether Selected or Not)\n"
						+"4. View his own Bid History\n"
						+"5. Exit\n");
		    	System.out.println("Enter Choice:");
		    	int choice2 = sc.nextInt();
				switch(choice2) {
				
				case 1:
					ViewAll_Tenders_Details_UseCases.viewAllTenders(args);
					break;
				
				case 2:
					BidAgainstTender_UseCases.bid_Against(args);
					
					break;
					
				case 3:
					
				 
				}
		    	 
			}	 
		    	
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
	}
