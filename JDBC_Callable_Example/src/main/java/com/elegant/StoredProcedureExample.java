package com.elegant;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class StoredProcedureExample {
	private static final String DRIVERCLASSNAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "system";
	private static final String PASSWORD = "tiger";

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cst = null;
		try {
			Class.forName(DRIVERCLASSNAME);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			cst = con.prepareCall("{ call insertData(?,?,?)}");
			cst.setInt(1, 7777);
			cst.setString(2, "Call_PROCEDURE");
			cst.setFloat(3, 6666.90f);
			cst.execute();
			System.out.println("Procedure Invoked.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				cst.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
