package com.spring.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.jdbc.dao.PersonDao;
import com.spring.jdbc.dao.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void save(Person person) {
		String sql = "insert into Person (first_Name, Last_Name, Address) "
				+ "values (:firstName, :lastName, :address)";
		jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(person));
	}

	@Override
	public Person load(long id) {
		List<Person> persons = jdbcTemplate.query("select * from Person where id =:id",
				new MapSqlParameterSource("id", id), (resultSet, i) -> {
					return toPerson(resultSet);
				});

		if (persons.size() == 1) {
			return persons.get(0);
		}
		return null;
	}

	@Override
	public void delete(long id) {
		jdbcTemplate.update("delete from PERSON where id = :id", new MapSqlParameterSource("id", id));
	}

	@Override
	public void updateAddress(long id, String newAddress) {

		jdbcTemplate.update("update PERSON set ADDRESS = :address where ID = :id",
				new MapSqlParameterSource("id", id).addValue("address", newAddress));
	}

	@Override
	public List<Person> loadAll() {
		return jdbcTemplate.query("select * from Person", (resultSet, i) -> {
			return toPerson(resultSet);
		});
	}

	private Person toPerson(ResultSet resultSet) throws SQLException {
		Person person = new Person();
		person.setId(resultSet.getLong("ID"));
		person.setFirstName(resultSet.getString("FIRST_NAME"));
		person.setLastName(resultSet.getString("LAST_NAME"));
		person.setAddress(resultSet.getString("ADDRESS"));
		return person;
	}

	@Override
	public List<Person> findPersonsByLastName(String name) {
		return jdbcTemplate.query("select * from Person where LAST_NAME = :lastName",
				new MapSqlParameterSource("lastName", name), (resultSet, i) -> {
					return toPerson(resultSet);
				});
	}

	@Override
	public Long getPersonCount() {
		return jdbcTemplate.queryForObject("select count(*) from PERSON", (HashMap) null, Long.class);

	}
}