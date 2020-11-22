package com.elegant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elegant.model.StudentModel;

@Repository
public class StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String INSERT_STUDENT = "INSERT INTO STUDENTDATA VALUES(?,?,?,?)";

	public void saveStudent(StudentModel studentModel) {
		jdbcTemplate.update(INSERT_STUDENT, studentModel.getRollNum(), studentModel.getName(),
				studentModel.getMarks(), studentModel.getAddress());
	}
}
