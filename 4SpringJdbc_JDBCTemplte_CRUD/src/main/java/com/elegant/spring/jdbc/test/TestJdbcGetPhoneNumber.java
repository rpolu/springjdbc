package com.elegant.spring.jdbc.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.spring.jdbc.dao.ContactDAO;

public class TestJdbcGetPhoneNumber {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cxac = new ClassPathXmlApplicationContext("spring-config.xml");
		ContactDAO contactDAO = cxac.getBean("contactDAO", ContactDAO.class);
		String phone = contactDAO.getPhoneNumber(1);
		System.out.println(phone);
	}
}
