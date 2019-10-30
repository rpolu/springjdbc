package com.elegant.jdbc.util.test.connection;

import com.elegant.jdbc.dao.UserDAO;

public class DeleteUserTest {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		int id = 1;
		userDAO.deleteUser(id);
		System.out.println("User details deleted successfully");

	}
}
