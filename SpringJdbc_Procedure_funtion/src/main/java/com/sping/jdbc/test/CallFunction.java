package com.sping.jdbc.test;

import java.math.BigDecimal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.ElegantDao;

public class CallFunction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cxac = new ClassPathXmlApplicationContext("spring-config.xml");
		ElegantDao elegantDao = cxac.getBean(ElegantDao.class);
		BigDecimal sum = elegantDao.callFunction(10, 20);
		System.out.println(sum);
		cxac.close();
	}
}