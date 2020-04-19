package com.elegant.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.dao.UserDao;

public class TestGetUserEmailRetrieve {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
		UserDao userDao = ac.getBean(UserDao.class);

		String email = userDao.getUserEmail(1);
		System.out.println(email);
		ac.close();
	}

}
