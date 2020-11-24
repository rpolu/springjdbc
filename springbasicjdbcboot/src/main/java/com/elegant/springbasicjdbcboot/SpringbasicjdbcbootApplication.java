package com.elegant.springbasicjdbcboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.elegant.dao.StudentDao;
import com.elegant.model.StudentModel;

@SpringBootApplication
@ComponentScan("com.elegant.*")
public class SpringbasicjdbcbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cp = SpringApplication.run(SpringbasicjdbcbootApplication.class, args);
		StudentDao studentDao = cp.getBean(StudentDao.class);

		StudentModel studentModel = new StudentModel();
		studentModel.setRollNum(111);
		studentModel.setName("NBK");
		studentModel.setMarks(90);
		studentModel.setAddress("Nimmakur");
		studentDao.saveStudent(studentModel);
		System.out.println("Student data saved successfully");

		studentDao.deleteStudent(111);

		System.out.println("Student data deleted successfully");
	}

}
