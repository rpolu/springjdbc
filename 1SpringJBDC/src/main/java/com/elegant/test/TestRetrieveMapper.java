package com.elegant.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.dao.UserDao;
import com.elegant.model.UserModel;

public class TestRetrieveMapper {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
		UserDao userDao = ac.getBean(UserDao.class);

		UserModel model = userDao.getUserRowMapper(1);
		System.out.println(model);

		ac.close();
	}

}
