package com.elegant.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.elegant.jdbc.util.ConnectionUtils;

public class AccountDAO {

	private static final String UPDATE_WITHDRAW_BAL = "UPDATE ACCOUNT SET balance =balance - ? WHERE ACCNUM = ?";
	private static final String UPDATE_DEPOSITE_BAL = "UPDATE ACCOUNT SET balance =balance + ? WHERE ACCNUM = ?";

	public void fundsTranfer(int fromAcc, int toAcc, float bal) {
		Connection connection = null;
		try {
			connection = ConnectionUtils.getConnection();
			connection.setAutoCommit(false);

			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_WITHDRAW_BAL);
			preparedStatement.setFloat(1, bal);
			preparedStatement.setInt(2, fromAcc);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();

			PreparedStatement preparedSt = connection.prepareStatement(UPDATE_DEPOSITE_BAL);
			preparedSt.setFloat(1, bal);
			preparedSt.setInt(2, toAcc);
			System.out.println(preparedSt);
			preparedSt.executeUpdate();

			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			closeConnection(connection);
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
