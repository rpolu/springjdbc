package com.elegant.jdbc.util.test.connection;

import com.elegant.jdbc.dao.UserDAO;
import com.elegant.jdbc.dao.impl.UserDaoImpl;

public class DeleteUserTest {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDaoImpl();
		int id = 1;
		userDAO.deleteUser(id);
		System.out.println("User details deleted successfully");

	}
}
