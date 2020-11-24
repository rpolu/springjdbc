package com.elegant.test1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.elegant.dao.StudentDao;
import com.elegant.model.StudentModel;

public class Test1 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext("apllicationConext.xml");
		StudentDao studentDao = cpxac.getBean(StudentDao.class);

		StudentModel sd = new StudentModel();
		sd.setRollNum(11);
		sd.setName("mohan");
		sd.setMarks(35);
		sd.setAddress("Kadapa");
		studentDao.saveStudent(sd);

		System.out.println("Saved the Student Data");
		cpxac.close();
	}
}
