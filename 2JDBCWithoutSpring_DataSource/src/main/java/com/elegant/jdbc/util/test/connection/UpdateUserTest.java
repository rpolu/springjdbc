package com.elegant.jdbc.util.test.connection;

import com.elegant.jdbc.dao.UserDAO;
import com.elegant.jdbc.dao.impl.UserDaoImpl;
import com.elegant.jdbc.model.User;

public class UpdateUserTest {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDaoImpl();
		int id = 1;
		String name = "Elegenat student";
		String email = "HHHH@gmail.com";
		String country = "America";
		User newUser = new User(id, name, email, country);
		userDAO.updateUser(newUser);
		System.out.println("User Details Updated  successfully .");
	}
}
