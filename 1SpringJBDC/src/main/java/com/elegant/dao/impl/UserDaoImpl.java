package com.elegant.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.elegant.dao.UserDao;
import com.elegant.mapper.UserMapper;
import com.elegant.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String INSERT_USERS_SQL = "INSERT INTO USERS (NAME, EMAIL, COUNTRY) VALUES  (?, ?, ?)";
	private static final String DELET_USERS_SQL = " DELETE FROM USERS WHERE ID=?";
	private static final String RETRIEVE_USER = "SELECT * FROM USERS WHERE ID=?";
	private static final String GET_ALL_USERS = "SELECT * FROM USERS";
	private static final String GET_USER_EMAIL = "SELECT EMAIL FROM USERS WHERE ID=?";

	public void saveUser(UserModel userModel) {
		jdbcTemplate.update(INSERT_USERS_SQL, userModel.getName(), userModel.getEmail(), userModel.getCountry());
	}

	public void deletUser(int userId) {
		jdbcTemplate.update(DELET_USERS_SQL, userId);
	}

	public UserModel getUser(int userId) {
		SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(RETRIEVE_USER, userId);

		UserModel userModel = new UserModel();
		if (sqlRowSet.next()) {
			userModel.setName(sqlRowSet.getString("NAME"));
			userModel.setEmail(sqlRowSet.getString("EMAIL"));
			userModel.setCountry(sqlRowSet.getString("COUNTRY"));
		}
		return userModel;
	}

	public UserModel getUserRowMapper(int userId) {
		return jdbcTemplate.queryForObject(RETRIEVE_USER, new UserMapper<UserModel>(), userId);
	}

	public List<UserModel> getUsers() {
		return jdbcTemplate.query(GET_ALL_USERS, new UserMapper<UserModel>());
	}

	public String getUserEmail(int userId) {
		return jdbcTemplate.queryForObject(GET_USER_EMAIL, String.class, userId);
	}

}
