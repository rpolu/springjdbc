package com.elegant.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elegant.model.UserModel;

public class UserMapper<T> implements RowMapper<UserModel> {

	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserModel userModel = new UserModel();
		userModel.setId(rs.getInt("ID"));
		userModel.setName(rs.getString("NAME"));
		userModel.setEmail(rs.getString("EMAIL"));
		userModel.setCountry(rs.getString("COUNTRY"));
		return userModel;
	}
}
