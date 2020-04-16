package com.elegant.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elegant.dao.UserDao;
import com.elegant.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String INSERT_USERS_SQL = "INSERT INTO USERS   (NAME, EMAIL, COUNTRY) VALUES  (?, ?, ?)";

	public void saveUser(UserModel userModel) {
		jdbcTemplate.update(INSERT_USERS_SQL, userModel.getName(), userModel.getEmail(), userModel.getCountry());
	}

}
