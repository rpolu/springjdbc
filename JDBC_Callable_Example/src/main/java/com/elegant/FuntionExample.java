package com.elegant;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class FuntionExample {
	private static final String DRIVERCLASSNAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "system";
	private static final String PASSWORD = "tiger";

	public static void main(String[] args) throws Exception {

		Class.forName(DRIVERCLASSNAME);
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		CallableStatement cst = con.prepareCall("{ ?=call manpulate(?,?)}");
		cst.registerOutParameter(1, Types.INTEGER);
		cst.setInt(2, 10);
		cst.setInt(3, 15);
		cst.execute();

		int sum = cst.getInt(1);
		System.out.println(sum);
		
		cst.close();
		con.close();
	}

}
