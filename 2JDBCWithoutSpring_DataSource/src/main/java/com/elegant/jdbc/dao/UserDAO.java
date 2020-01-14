package com.elegant.jdbc.dao;

import java.util.List;

import com.elegant.jdbc.model.User;

public interface UserDAO {

	public void saveUser(User user);

	public User getUser(int id);

	public List<User> getALLUsers();

	public boolean deleteUser(int id);

	public boolean updateUser(User user);

}
