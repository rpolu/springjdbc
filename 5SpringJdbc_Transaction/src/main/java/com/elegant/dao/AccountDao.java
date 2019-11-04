package com.elegant.dao;

public interface AccountDao {
	public void withDraw(int accountNum, float bal);

	public void deposite(int accountNum, float bal);

}
