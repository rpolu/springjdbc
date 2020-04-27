package com.sping.jdbc.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.ElegantDao;

public class CallProcedure {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cxac = new ClassPathXmlApplicationContext("spring-config.xml");
		ElegantDao elegantDao = cxac.getBean(ElegantDao.class);
		elegantDao.callProcudure(10, "rama", 9009);
		System.out.println("Contact details saved successfully");
		cxac.close();
	}
}