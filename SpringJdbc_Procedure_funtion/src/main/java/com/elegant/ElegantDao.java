package com.elegant;

import java.math.BigDecimal;

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

	public void callProcudure(int id, String name, float amt) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("insertData");

		SqlParameterSource in = new MapSqlParameterSource().addValue("id", id).addValue("name", name).addValue("amt",
				amt);

		simpleJdbcCall.execute(in);
	}

	public BigDecimal callFunction(int n1, int n2) {

		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName("manpulate");

		SqlParameterSource in = new MapSqlParameterSource().addValue("a1", n1).addValue("a2", n2);

		BigDecimal sum = simpleJdbcCall.executeFunction(BigDecimal.class, in);
		return sum;

	}

}
