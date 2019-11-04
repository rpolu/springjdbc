package com.elegant.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elegant.dao.AccountDao;

@Service
public class AccountService {

	@Autowired
	private AccountDao accountDao;

	@Transactional
	public void fundsTransfer(int fromAcc, int toAcc, float bal) {
		accountDao.withDraw(fromAcc, bal);
		accountDao.deposite(toAcc, bal);
	}

}
