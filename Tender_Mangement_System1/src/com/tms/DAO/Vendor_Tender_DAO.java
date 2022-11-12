package com.tms.DAO;

import java.util.List;

import com.tms.Exception.TenderAssignedException;
import com.tms.bean.Vendor_Tender_details;

public interface Vendor_Tender_DAO {
	
	public List<Vendor_Tender_details> viewAssignedDetails(int bid_tender)throws TenderAssignedException;

}
