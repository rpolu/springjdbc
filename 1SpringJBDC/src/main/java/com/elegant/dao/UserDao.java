package com.elegant.dao;

import com.elegant.model.UserModel;

public interface UserDao {

	public void saveUser(UserModel userModel);

	public void deletUser(int userId);

}
