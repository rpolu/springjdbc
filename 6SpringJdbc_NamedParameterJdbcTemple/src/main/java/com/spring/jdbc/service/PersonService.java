package com.spring.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jdbc.dao.PersonDao;
import com.spring.jdbc.dao.model.Person;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao;

	public void savePerson(Person person) {
		dao.save(person);
	}

	public Long getPersonCount() {
		return dao.getPersonCount();
	}

	public List<Person> getAllPersons() {
		return dao.loadAll();
	}

	public List<Person> getPersonsByLastName(String lastName) {
		return dao.findPersonsByLastName(lastName);
	}

	public Person getPersonById(long id) {
		return dao.load(id);
	}

	public void updateAddress(long id, String address) {
		dao.updateAddress(id, address);
	}

	public void deletePerson(long id) {
		dao.delete(id);
	}
}