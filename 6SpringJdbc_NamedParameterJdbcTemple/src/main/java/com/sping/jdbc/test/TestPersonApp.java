package com.sping.jdbc.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.config.SpringConfig;
import com.spring.jdbc.dao.model.Person;
import com.spring.jdbc.service.PersonService;

public class TestPersonApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(SpringConfig.class);
		context.refresh();
		PersonService personService = context.getBean(PersonService.class);

		Person person = Person.create("Rama", "mohan", "Bangalore");
		personService.savePerson(person);

		person = Person.create("VVV", "HHH", "Hyd");
		personService.savePerson(person);

		System.out.println("person count " + personService.getPersonCount());

		List<Person> persons = personService.getPersonsByLastName("mohan");

		System.out.println("persons found by last name " + persons);

		person = personService.getPersonById(2);

		System.out.println("found person by id : " + person);

		System.out.println("All persons : " + personService.getAllPersons());

		personService.updateAddress(1, "Marathalli bridge");

		System.out.println("Address updated " + personService.getPersonById(1));

		personService.deletePerson(2);

		System.out.println("All persons : " + personService.getAllPersons());

		context.close();

	}
}