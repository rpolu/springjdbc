package com.elegant.jdbc.util.test.connection;

import java.util.List;

import com.elegant.jdbc.dao.UserDAO;
import com.elegant.jdbc.dao.impl.UserDaoImpl;
import com.elegant.jdbc.model.User;

public class GetUserListTest {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDaoImpl();
		List<User> users = userDAO.getALLUsers();
		for (User user : users) {
			System.out.println(user.getId());
			System.out.println(user.getName());
			System.out.println(user.getEmail());
			System.out.println(user.getCountry());
			System.out.println("__________________________________");
		}
	}
}
