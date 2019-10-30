package com.elegant.jdbc.util.test.connection;

import java.sql.Connection;

import com.elegant.jdbc.util.ConnectionUtils;

public class TestConnection {
	public static void main(String[] args) {
		Connection connection = ConnectionUtils.getConnection();
		System.out.println(connection);
		ConnectionUtils.closeConnection();
	}

}
