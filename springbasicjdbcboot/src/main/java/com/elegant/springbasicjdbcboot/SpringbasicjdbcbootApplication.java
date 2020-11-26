package com.elegant.springbasicjdbcboot;

import java.util.List;

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

		StudentModel su = new StudentModel();
		su.setRollNum(11);
		su.setMarks(20);
		su.setAddress("hyd");
		studentDao.updateStudent(su);

		System.out.println("Student Details Updated");

		StudentModel studentModel = new StudentModel();
		studentModel.setRollNum(111);
		studentModel.setName("NBK");
		studentModel.setMarks(90);
		studentModel.setAddress("Nimmakur");
		studentDao.saveStudent(studentModel);
		System.out.println("Student data saved successfully");

		StudentModel sm = studentDao.getStudent(11);

		System.out.println(sm.getRollNum());
		System.out.println(sm.getName());
		System.out.println(sm.getMarks());
		System.out.println(sm.getAddress());

		System.out.println("----------------------------------");

		StudentModel sm1 = studentDao.getStudent(111);

		System.out.println(sm1.getRollNum());
		System.out.println(sm1.getName());
		System.out.println(sm1.getMarks());
		System.out.println(sm1.getAddress());

		System.out.println("----------------------------------");

		List<StudentModel> sms = studentDao.getStudents();

		sms.stream().forEach(s -> {
			System.out.println(s.getRollNum());
			System.out.println(s.getName());
			System.out.println(s.getMarks());
			System.out.println(s.getAddress());
		});

		studentDao.deleteStudent(111);

		System.out.println("Student data deleted successfully");
	}

}
