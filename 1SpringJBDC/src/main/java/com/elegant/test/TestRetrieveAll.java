package com.elegant.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.dao.UserDao;
import com.elegant.model.UserModel;

public class TestRetrieveAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
		UserDao userDao = ac.getBean(UserDao.class);

		List<UserModel> modelList = userDao.getUsers();
		for (UserModel um : modelList) {
			System.out.println(um);
		}

		ac.close();
	}

}
