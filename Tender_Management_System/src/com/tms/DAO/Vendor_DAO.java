package com.tms.DAO;

import com.tms.Exception.RegisterNewVendorException;

public interface Vendor_DAO {
	
	public String adminLogin(String username, String password);
	
	public String registerNewVendor(String name, int gst_no, String edate, String email, String password, int signature_id)throws RegisterNewVendorException;


}
