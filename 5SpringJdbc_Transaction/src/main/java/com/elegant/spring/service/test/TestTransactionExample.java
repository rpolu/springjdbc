package com.elegant.spring.service.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.spring.service.AccountService;

public class TestTransactionExample {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext cxac = new ClassPathXmlApplicationContext("spring-config.xml");
		AccountService accountService = cxac.getBean("accountService", AccountService.class);
		accountService.fundsTransfer(2, 1, 500);
		System.out.println("Completed successfully");

	}

}
