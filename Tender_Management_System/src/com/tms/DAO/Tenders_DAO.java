package com.tms.DAO;

import java.util.List;

import com.tms.Exception.TendersDetailsException;
import com.tms.bean.Tenders;

public interface Tenders_DAO {
	
	public String registerTenders(int tender_id, String flat_type, int base_price, String furniture, String location, String s_date,
			String e_date)throws TendersDetailsException;
	
	public List<Tenders> viewAllTendersDetails()throws TendersDetailsException;

}
