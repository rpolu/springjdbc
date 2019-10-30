package com.elegant.jdbc.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {
	private static Properties configProp = new Properties();
	private static Connection connection = null;
	static {
		try {
			configProp.load(ConnectionUtils.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			Class.forName(configProp.getProperty("jdbc.driver"));
			String url = configProp.getProperty("jdbc.url");
			String userName = configProp.getProperty("jdbc.username");
			String password = configProp.getProperty("jdbc.password");
			connection = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}