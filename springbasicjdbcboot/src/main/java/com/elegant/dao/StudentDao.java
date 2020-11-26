package com.elegant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.elegant.mapper.StudentRowMapper;
import com.elegant.model.StudentModel;

@Repository
public class StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String INSERT_STUDENT = "INSERT INTO STUDENTDATA VALUES(?,?,?,?)";
	private String DELETE_STUDENT = "DELETE FROM STUDENTDATA WHERE ROLLNUM=?";
	private String GET_STUDENT = "SELECT * FROM STUDENTDATA WHERE ROLLNUM=?";
	private String GET_STUDENTS = "SELECT * FROM STUDENTDATA";
	private String UPDATE_STUDENT = "UPDATE STUDENTDATA SET  MARKS = MARKS + ? , ADDRESS = ? WHERE ROLLNUM=? ";

	public void saveStudent(StudentModel studentModel) {
		jdbcTemplate.update(INSERT_STUDENT, studentModel.getRollNum(), studentModel.getName(), studentModel.getMarks(),
				studentModel.getAddress());
	}

	public void updateStudent(StudentModel studentModel) {
		jdbcTemplate.update(UPDATE_STUDENT, studentModel.getMarks(), studentModel.getAddress(),
				studentModel.getRollNum());
	}

	public void deleteStudent(int rollNum) {
		jdbcTemplate.update(DELETE_STUDENT, rollNum);
	}

	// With out Row Mapper
	public StudentModel getStudent(int rollNum) {
		StudentModel studentModel = new StudentModel();
		SqlRowSet srs = jdbcTemplate.queryForRowSet(GET_STUDENT, rollNum);
		if (srs.next()) {
			studentModel.setRollNum(rollNum);
			studentModel.setName(srs.getString("NAME"));
			studentModel.setMarks(srs.getInt("MARKS"));
			studentModel.setAddress(srs.getString("ADDRESS"));
		}
		return studentModel;
	}

	// With Row Mapper==> Better approch
	public StudentModel getStudentDetails(int rollNum) {
		return jdbcTemplate.queryForObject(GET_STUDENT, new StudentRowMapper(), rollNum);
	}

	public List<StudentModel> getStudents() {
		return jdbcTemplate.query(GET_STUDENTS, new StudentRowMapper());
	}

}
