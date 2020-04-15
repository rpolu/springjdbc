package com.elegant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {

	public static void main(String[] args) {

		try {
			String diverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/SYSTEM";
			String un = "root";
			String pass = "Root@123";
			Class.forName(diverClass);
			Connection conn = DriverManager.getConnection(url, un, pass);

			String query = "insert into employee values (?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, 124);
			pst.setString(2, "abc@gmail.com");
			pst.setString(3, "rama");
			pst.setString(4, "mohan");
			int rows = pst.executeUpdate();

			System.out.println(rows + " :inserted ");

			pst.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
