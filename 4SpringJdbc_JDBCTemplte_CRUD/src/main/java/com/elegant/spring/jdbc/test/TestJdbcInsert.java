package com.elegant.spring.jdbc.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.spring.jdbc.dao.ContactDAO;
import com.elegant.spring.jdbc.model.Contact;

public class TestJdbcInsert {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cxac = new ClassPathXmlApplicationContext("spring-config.xml");
		ContactDAO contactDAO = cxac.getBean("contactDAO", ContactDAO.class);
		Contact contact = new Contact();
		contact.setName("Rama");
		contact.setEmail("abc@gmail.com");
		contact.setAddress("Bangalore");
		contact.setTelephone("998888222");
		contactDAO.saveContact(contact);
		System.out.println("Contact details saved successfully");

	}

}
