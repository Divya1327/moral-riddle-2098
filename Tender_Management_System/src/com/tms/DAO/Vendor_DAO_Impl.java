package com.tms.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tms.Exception.RegisterNewVendorException;
import com.tms.Utility.DBUtility;

public class Vendor_DAO_Impl implements Vendor_DAO{

	@Override
	public String adminLogin(String username, String password) {
    String status = "Login failed...";
		
		try(Connection conn = DBUtility.provideTenderConnection()) {
			
			PreparedStatement psE = conn.prepareStatement("Select * from administrator where email =?");
			
			psE.setString(1, username);
			
			ResultSet rsE = psE.executeQuery();
			
			if(rsE.next()) {
				
				PreparedStatement ps = conn.prepareStatement("Select email from administrator where password = ?");
				
				ps.setString(1, password);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					
					String email = rs.getString("email");
					
					if(email.equals(username)) {
					
						status = "Login Successful...";
						
						}else {
						status = "username and password mismatch....\n";
						
						}
					
				}else {
					status = "password not correct according username\n";
				}
				
				
			}else {
				status = "username not found..\n";
			}
					
		} catch (SQLException e) {
			status = e.getMessage();
		}
		
		
		return status;
		
	}

	@Override
	public String registerNewVendor(String name, int gst_no, String edate, String email, String password,
			int signature_id) throws RegisterNewVendorException {
    String status = "Login failed...";
		
		try(Connection conn = DBUtility.provideTenderConnection()) {
			
			PreparedStatement psE = conn.prepareStatement("Select * from vendor where email =?");
			
			String username = null;
			psE.setString(1, username);
			
			ResultSet rsE = psE.executeQuery();
			
			if(rsE.next()) {
				
				PreparedStatement ps = conn.prepareStatement("Select email from vendor where password = ?");
				
				ps.setString(1, password);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					
					String email1 = rs.getString("email");
					
					if(email1.equals(username)) {
					
						status = "Login Successful...";
						
						
					}else {
						status = "username and password mismatch....\n";
					}
					
				}else {
					status = "password not correct according username\n";
				}
				
				
			}else {
				status = "username not found..\n";
			}
		
		} catch (SQLException e) {
			status = e.getMessage();
		}
		
		return status;
	}

}
