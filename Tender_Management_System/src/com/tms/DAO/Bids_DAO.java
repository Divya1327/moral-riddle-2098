package com.tms.DAO;

import com.tms.Exception.BidInsertException;

public interface Bids_DAO {
	
	public String bidAgainstTender(int offerPrice, int bid_tender, int bid_vendor, String status)throws BidInsertException;

}
