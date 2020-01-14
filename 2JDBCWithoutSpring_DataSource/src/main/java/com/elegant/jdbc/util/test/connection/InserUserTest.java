package com.elegant.jdbc.util.test.connection;

import com.elegant.jdbc.dao.UserDAO;
import com.elegant.jdbc.dao.impl.UserDaoImpl;
import com.elegant.jdbc.model.User;

public class InserUserTest {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDaoImpl();
		String name = "Rama Mohan Reddy";
		String email = "rpolu.tech8@gmail.com";
		String country = "India";
		User newUser = new User(name, email, country);
		userDAO.saveUser(newUser);
		System.out.println("User Details Saved successfully .");

	}
}
