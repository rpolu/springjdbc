package com.elegant.test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.elegant.dao.UserDao;
public class TestDelete {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
		UserDao userDao = ac.getBean(UserDao.class);
		userDao.deletUser(2);
		System.out.println(" User Detail Deleted");
		ac.close();
	}

}
