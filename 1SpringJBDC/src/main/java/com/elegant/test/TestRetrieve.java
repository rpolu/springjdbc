package com.elegant.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.dao.UserDao;
import com.elegant.model.UserModel;

public class TestRetrieve {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
		UserDao userDao = ac.getBean(UserDao.class);

		UserModel model = userDao.getUser(1);
		System.out.println(model);

		ac.close();
	}

}
