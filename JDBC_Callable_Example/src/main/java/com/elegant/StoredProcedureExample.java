package com.elegant;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class StoredProcedureExample {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
		String query = "{ call insertData(?,?,?)}";
		CallableStatement cst = con.prepareCall(query);
		cst.setInt(1, 101);
		cst.setString(2, "ram");
		cst.setFloat(3, 899);
		cst.execute();
		System.out.println("Procedure calles succe fully");
		cst.close();
		con.close();

	}

}
