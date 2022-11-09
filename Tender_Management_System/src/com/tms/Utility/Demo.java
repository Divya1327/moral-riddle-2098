package com.tms.Utility;

import java.sql.Connection;

public class Demo {

	public static void main(String[] args) {
		Connection conn= DBUtility.provideTenderConnection();
		System.out.println(conn);

	}

}
