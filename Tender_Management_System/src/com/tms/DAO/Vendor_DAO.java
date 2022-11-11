package com.tms.DAO;

import java.util.List;

import com.tms.Exception.RegisterNewVendorException;
import com.tms.Exception.VendorDetailsExecption;
import com.tms.bean.Vendor;

public interface Vendor_DAO {
	
	public String adminLogin(String username, String password);
	
	public String registerNewVendor(String name, int gst_no, String edate, String email, String password, int signature_id)throws RegisterNewVendorException;

	public List<Vendor> viewAllVendorsList() throws VendorDetailsExecption;

}
