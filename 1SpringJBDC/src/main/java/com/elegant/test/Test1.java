package com.elegant.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.dao.UserDao;
import com.elegant.model.UserModel;

public class Test1 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
		UserDao userDao = ac.getBean(UserDao.class);

		UserModel model = new UserModel();
		model.setName("Ele_WFH");
		model.setEmail("abc@gmail.com");
		model.setCountry("India");
		userDao.saveUser(model);

		System.out.println(" Inserted Data");
		ac.close();
	}

}
