package com.elegant.jdbc.util.test.connection;

import com.elegant.jdbc.dao.AccountDAO;

public class TestTransaction {
	public static void main(String[] args) {
		AccountDAO dao = new AccountDAO();
		dao.fundsTranfer(1, 2, 1000);
		System.out.println("completed the transaction.");
	}

}
