package com.elegant.spring.jdbc.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.spring.jdbc.dao.ContactDAO;
import com.elegant.spring.jdbc.model.Contact;

public class TestJdbcPhoneEmail {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cxac = new ClassPathXmlApplicationContext("spring-config.xml");
		ContactDAO contactDAO = cxac.getBean("contactDAO", ContactDAO.class);
		Contact contact = contactDAO.getPhoneAndEmail(1);
		System.out.println(contact.getTelephone());
		System.out.println(contact.getEmail());
	}
}
