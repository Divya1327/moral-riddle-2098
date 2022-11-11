package com.tms.UseCases;

import java.util.List;
import com.tms.DAO.Tenders_DAO;
import com.tms.DAO.Tenders_DAO_Impl;
import com.tms.Exception.TendersDetailsException;
import com.tms.bean.Tenders;

public class ViewAll_Tenders_Details_UseCases {

	public static void viewAllTenders(String[] args) {
		Tenders_DAO dao5 = new Tenders_DAO_Impl();
	
		try {
			List<Tenders> list2 = dao5.viewAllTendersDetails();
			
			System.out.println("\n LIST OF TENDERS WITH FULL DETAILS");
			System.out.println("===================================");
			
			list2.forEach(s-> {
				
				System.out.println("Tender Id: "+s.getTender_id());
				System.out.println("Flat Type: "+s.getFlat_type());
				System.out.println("Base Price: "+s.getBase_price());
				System.out.println("Furniture: "+s.getFurniture());
				System.out.println("Location: "+s.getLocation());
				System.out.println("Start Date: "+s.getS_date());
				System.out.println("End Date: "+s.getE_date());
				
				System.out.println("--------****------****--------");
			});
			
		} catch (TendersDetailsException e) {
			
			System.out.println(e.getMessage());
		}
	
	}

}
