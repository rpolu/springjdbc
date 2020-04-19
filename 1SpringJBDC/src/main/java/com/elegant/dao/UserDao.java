package com.elegant.dao;

import java.util.List;

import com.elegant.model.UserModel;

public interface UserDao {

	public void saveUser(UserModel userModel);

	public void deletUser(int userId);

	public UserModel getUser(int userId);

	public UserModel getUserRowMapper(int userId);

	public List<UserModel> getUsers();
	
	public String getUserEmail(int userId);

}
