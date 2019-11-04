package com.elegant.spring.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.elegant.spring.jdbc.dao.ContactDAO;
import com.elegant.spring.jdbc.mapper.ContactRowMapper;
import com.elegant.spring.jdbc.model.Contact;

@Repository("contactDAO")
public class ContactDAOImpl implements ContactDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String INSERT_CONTACT = "INSERT INTO CONTACT (NAME, EMAIL, ADDRESS, TELEPHONE) VALUES (?, ?, ?, ?)";
	private static final String UPDATE_CONTACT = "UPDATE CONTACT SET NAME=?, EMAIL=?, ADDRESS=?, TELEPHONE=? WHERE CONTACT_ID=?";
	private static final String DELETE_CONTACT = "DELETE FROM CONTACT WHERE CONTACT_ID=?";

	public void saveContact(Contact contact) {
		jdbcTemplate.update(INSERT_CONTACT, contact.getName(), contact.getEmail(), contact.getAddress(),
				contact.getTelephone());
	}

	public void updateContact(Contact contact) {
		jdbcTemplate.update(UPDATE_CONTACT, contact.getName(), contact.getEmail(), contact.getAddress(),
				contact.getTelephone(), contact.getId());
	}

	public void deleteContact(int contactId) {

		jdbcTemplate.update(DELETE_CONTACT, contactId);
	}

	public String getPhoneNumber(int contactId) {
		String GET_PHONE = "SELECT TELEPHONE FROM CONTACT WHERE CONTACT_ID= ? ";
		String phoneNumber = jdbcTemplate.queryForObject(GET_PHONE, new Object[] { contactId }, String.class);
		return phoneNumber;
	}

	public Contact getPhoneAndEmail(int contactId) {
		String GET_PHONE_EMAIL = "SELECT TELEPHONE ,EMAIL FROM CONTACT WHERE CONTACT_ID= ? ";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(GET_PHONE_EMAIL, contactId);
		Contact contact = new Contact();
		if (rowSet.next()) {
			contact.setTelephone(rowSet.getString(1));
			contact.setEmail(rowSet.getString(2));
		}
		return contact;
	}

	public Contact getContact(int contactId) {
		String GET_CONTACT = "SELECT * FROM CONTACT WHERE CONTACT_ID= ? ";
		Contact contact = jdbcTemplate.queryForObject(GET_CONTACT, new ContactRowMapper(), contactId);
		return contact;
	}

	public List<Contact> getAllContacts() {
		String GET_CONTACT = "SELECT * FROM CONTACT";
		List<Contact> contacts = jdbcTemplate.query(GET_CONTACT, new ContactRowMapper());
		return contacts;
	}

}