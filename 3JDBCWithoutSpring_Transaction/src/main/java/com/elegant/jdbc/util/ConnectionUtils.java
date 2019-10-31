package com.elegant.jdbc.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionUtils {
	private static BasicDataSource dataSource = null;
	private static Properties configProp = new Properties();
	static {
		try {
			configProp.load(ConnectionUtils.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		if (dataSource == null) {
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName(configProp.getProperty("jdbc.driver"));
			ds.setUrl(configProp.getProperty("jdbc.url"));
			ds.setUsername(configProp.getProperty("jdbc.username"));
			ds.setPassword(configProp.getProperty("jdbc.password"));
			ds.setMinIdle(5);
			ds.setMaxIdle(10);
			ds.setMaxOpenPreparedStatements(100);
			dataSource = ds;
		}
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}