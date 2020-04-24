package com.elegant;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class FuntionExample {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
		String query = "{? =call manpulate(?,?)}";
		CallableStatement cst = con.prepareCall(query);
		cst.registerOutParameter(1, Types.INTEGER);
		cst.setInt(2, 10);
		cst.setInt(3, 20);
		cst.execute();
		System.out.println(cst.getInt(1));
		System.out.println("Function calles succe fully");
		cst.close();
		con.close();

	}

}
