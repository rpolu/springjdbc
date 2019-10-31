package com.elegant.spring.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.elegant.spring.jdbc.dao.ContactDAO;
import com.elegant.spring.jdbc.model.Contact;

@Repository("contactDAO")
public class ContactDAOImpl implements ContactDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveContact(Contact contact) {
		String sql = "INSERT INTO contact (name, email, address, telephone)" + " VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getTelephone());

	}

	public void updateContact(Contact contact) {
		// update
		String sql = "UPDATE contact SET name=?, email=?, address=?, " + "telephone=? WHERE contact_id=?";
		jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getTelephone(),
				contact.getId());
	}

	public void deleteContact(int contactId) {
		String sql = "DELETE FROM contact WHERE contact_id=?";
		jdbcTemplate.update(sql, contactId);
	}

	public Contact getContact(int contactId) {
		return null;
	}

	public List<Contact> contactlist() {
		return null;
	}

}