package com.elegant.spring.jdbc.dao;

import java.util.List;

import com.elegant.spring.jdbc.model.Contact;

public interface ContactDAO {

	public void saveContact(Contact contact);

	public void updateContact(Contact contact);

	public void deleteContact(int contactId);

	public Contact getContact(int contactId);

	public List<Contact> contactlist();
}