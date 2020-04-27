package com.elegant.namedparams.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.dao.AccountDao;
import com.elegant.model.Account;

public class TestNamedParamters {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext cxap = new ClassPathXmlApplicationContext("spring-config.xml");

		AccountDao accountDao = cxap.getBean(AccountDao.class);

		Account account = new Account();
		account.setAccNum(2222);
		account.setName("ElegnatAccout");
		account.setBalance(9000.90f);
		accountDao.saveAccount(account);

		System.out.println("Account detais saved successfully");
		
		cxap.close();
	}

}
