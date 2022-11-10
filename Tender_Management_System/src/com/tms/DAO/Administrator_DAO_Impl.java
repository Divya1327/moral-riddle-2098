package com.tms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tms.Utility.DBUtility;

public class Administrator_DAO_Impl implements Administrator_DAO{

	@Override
	public String registerAdmin(int id, String name, String dob, String email, String password) {
		
    String status = "Not Registered..";
		
		try(Connection conn = DBUtility.provideTenderConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into administrator values(?,?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, dob);
			ps.setNString(4, email);
			ps.setString(5, password);
			
			int x = ps.executeUpdate();
			
			if(x>0)
				status = "Registered Successfully...";
			
			
		} catch (SQLException e) {
			status = e.getMessage();
		}
		

		return status;
	}

		
	

}
