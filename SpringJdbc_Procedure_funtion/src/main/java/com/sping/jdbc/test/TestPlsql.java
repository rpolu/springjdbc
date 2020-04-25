package com.sping.jdbc.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.ElegantDao;

public class TestPlsql {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cxac = new ClassPathXmlApplicationContext("spring-config.xml");
		ElegantDao elegantDao = cxac.getBean("contactDAO", ElegantDao.class);
		elegantDao.callProcudure(10,"rama",9009);
		System.out.println("Contact details saved successfully");
		cxac.close();
	}
}