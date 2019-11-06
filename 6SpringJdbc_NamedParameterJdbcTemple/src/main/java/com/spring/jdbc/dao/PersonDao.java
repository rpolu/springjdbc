package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.dao.model.Person;

public interface PersonDao {

	List<Person> findPersonsByLastName(String firstName);

	Long getPersonCount();

	void updateAddress(long id, String newAddress);

	void save(Person person);

	Person load(long id);

	void delete(long id);

	List<Person> loadAll();

}