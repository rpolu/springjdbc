package com.elegant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elegant.model.Account;

@Repository
public class AccountDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private static final String INSER_ACCOUNT = "INSERT INTO ACCOUNT(ACNUM,NAME,BALANCE) VALUES(:accnum,:name,:bal)";

	public void saveAccount(Account model) {

		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("accnum", model.getAccNum());
		sps.addValue("name", model.getName());
		sps.addValue("bal", model.getBalance());
		jdbcTemplate.update(INSER_ACCOUNT, sps);
	}

}
