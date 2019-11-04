package com.elegant.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elegant.dao.AccountDao;

@Repository
public class AccountDaoImpl implements AccountDao {
	private static final String UPDATE_WITHDRAW_BAL = "UPDATE ACCOUNT SET balance =balance - ? WHERE ACCNUM = ?";
	private static final String UPDATE_DEPOSITE_BAL = "UPDATE ACCOUNT SET balance =balance + ? WHERE ACCNU = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void withDraw(int accountNum, float bal) {
		jdbcTemplate.update(UPDATE_WITHDRAW_BAL, bal, accountNum);
	}

	public void deposite(int accountNum, float bal) {
		jdbcTemplate.update(UPDATE_DEPOSITE_BAL, bal, accountNum);
	}

}
