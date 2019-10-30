package com.elegant.jdbc.util.test.connection;

import java.sql.Connection;
import java.sql.SQLException;

import com.elegant.jdbc.util.ConnectionUtils;

public class TestConnection {
	public static void main(String[] args) {
		Connection connection = ConnectionUtils.getConnection();
		System.out.println(connection);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
