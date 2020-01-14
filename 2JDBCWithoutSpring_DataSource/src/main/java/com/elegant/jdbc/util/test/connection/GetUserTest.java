package com.elegant.jdbc.util.test.connection;

import com.elegant.jdbc.dao.UserDAO;
import com.elegant.jdbc.dao.impl.UserDaoImpl;
import com.elegant.jdbc.model.User;

public class GetUserTest {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDaoImpl();
		User user = userDAO.getUser(2);
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getCountry());
	}
}
