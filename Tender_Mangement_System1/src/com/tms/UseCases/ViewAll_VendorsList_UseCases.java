package com.tms.UseCases;

import java.util.List;

import com.tms.DAO.Vendor_DAO;
import com.tms.DAO.Vendor_DAO_Impl;
import com.tms.Exception.VendorDetailsExecption;
import com.tms.bean.Vendor;

public class ViewAll_VendorsList_UseCases {

	public static void View_Vendorlist(String[] args) {
		Vendor_DAO dao3 = new Vendor_DAO_Impl();
		
		
		
		try {
			List<Vendor> list = dao3.viewAllVendorsList();
			
			System.out.println("\n LIST OF VENDORS WITH FULL DETAILS");
			System.out.println("===================================");
			
			list.forEach(s-> {
				
				System.out.println("Vendor Id: "+s.getId());
				System.out.println("Vendor Name: "+s.getVname());
				System.out.println("Vendor GST No.: "+s.getGst_no());
				System.out.println("Vendor Establishment: "+s.getEdate());
				System.out.println("Vendor Email: "+s.getEmail());
				System.out.println("Vendor Password: "+s.getPassword());
				System.out.println("Admin SignatureId: "+s.getSignature_id());
				
				System.out.println("----------****--------****---------");
			});
			
			
		} catch (VendorDetailsExecption e) {
			
			System.out.println(e.getMessage());
		}
	

	}

}
