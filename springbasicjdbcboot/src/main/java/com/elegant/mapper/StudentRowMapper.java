package com.elegant.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elegant.model.StudentModel;

public class StudentRowMapper implements RowMapper<StudentModel> {

	public StudentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentModel studentModel = new StudentModel();
		studentModel.setRollNum(rs.getInt("ROLLNUM"));
		studentModel.setName(rs.getString("NAME"));
		studentModel.setMarks(rs.getInt("MARKS"));
		studentModel.setAddress(rs.getString("ADDRESS"));
		return studentModel;
	}

}
