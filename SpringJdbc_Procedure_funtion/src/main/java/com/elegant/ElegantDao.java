package com.elegant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class ElegantDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void classProcudure(int id, String name, float amt) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("insertData");
		SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id).addValue("in_name", name)
				.addValue("in_name", name).addValue("in_salary", amt);
		simpleJdbcCall.execute(in);
	}

	public void callFunction() {

	}

}
