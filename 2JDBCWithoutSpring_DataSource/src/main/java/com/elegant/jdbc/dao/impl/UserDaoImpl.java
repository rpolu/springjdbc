package com.elegant.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.elegant.jdbc.dao.UserDAO;
import com.elegant.jdbc.model.User;
import com.elegant.jdbc.util.ConnectionUtils;

public class UserDaoImpl implements UserDAO {

	private static final String INSERT_USERS_SQL = "INSERT INTO USERS   (NAME, EMAIL, COUNTRY) VALUES  (?, ?, ?)";
	private static final String SELECT_USER_BY_ID = "SELECT ID,NAME,EMAIL,COUNTRY FROM USERS WHERE ID =?";
	private static final String SELECT_ALL_USERS = "SELECT * FROM USERS";
	private static final String DELETE_USERS_SQL = "DELETE FROM USERS WHERE ID = ?";
	private static final String UPDATE_USERS_SQL = "UPDATE USERS SET NAME = ?,EMAIL= ?, COUNTRY =? WHERE ID = ?";

	public void saveUser(User user) {
		System.out.println(INSERT_USERS_SQL);
		Connection connection = null;
		try {
			connection = ConnectionUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			closeConnection(connection);
		}
	}

	public User getUser(int id) {
		User user = null;
		Connection connection = null;
		try {
			connection = ConnectionUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				user = new User(id, name, email, country);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			closeConnection(connection);
		}
		return user;
	}

	public List<User> getALLUsers() {
		List<User> users = new ArrayList<>();
		Connection connection = null;
		try {
			connection = ConnectionUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				users.add(new User(id, name, email, country));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			closeConnection(connection);
		}
		return users;
	}

	public boolean deleteUser(int id) {
		boolean rowDeleted = false;
		Connection connection = null;
		try {
			connection = ConnectionUtils.getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			closeConnection(connection);
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) {
		boolean rowUpdated = false;
		Connection connection = null;
		try {
			connection = ConnectionUtils.getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getCountry());
			statement.setInt(4, user.getId());
			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			printSQLException(e);
		} finally {
			closeConnection(connection);
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	private void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
