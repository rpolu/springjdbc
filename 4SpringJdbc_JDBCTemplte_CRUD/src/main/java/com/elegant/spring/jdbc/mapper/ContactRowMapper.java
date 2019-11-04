package com.elegant.spring.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.elegant.spring.jdbc.model.Contact;

public class ContactRowMapper implements RowMapper<Contact> {
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setId(rs.getInt("CONTACT_ID"));
		contact.setName(rs.getString("NAME"));
		contact.setEmail(rs.getString("EMAIL"));
		contact.setAddress(rs.getString("ADDRESS"));
		contact.setTelephone(rs.getString("TELEPHONE"));
		return contact;
	}
}
