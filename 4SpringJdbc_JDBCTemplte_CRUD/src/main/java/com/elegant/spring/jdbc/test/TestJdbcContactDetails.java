package com.elegant.spring.jdbc.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.spring.jdbc.dao.ContactDAO;
import com.elegant.spring.jdbc.model.Contact;

public class TestJdbcContactDetails {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cxac = new ClassPathXmlApplicationContext("spring-config.xml");
		ContactDAO contactDAO = cxac.getBean("contactDAO", ContactDAO.class);
		Contact contact = contactDAO.getContact(1);
		System.out.println(contact.getName());
		System.out.println(contact.getAddress());
		System.out.println(contact.getTelephone());
		System.out.println(contact.getEmail());
	}
}
