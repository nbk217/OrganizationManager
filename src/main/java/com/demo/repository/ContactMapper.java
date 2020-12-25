package com.demo.repository;

import com.demo.model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements RowMapper {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setId(rs.getInt("id"));
        contact.setName(rs.getString("name"));
        contact.setMobile(rs.getString("phone1"));
        contact.setSecondaryMobile(rs.getString("phone2"));
        contact.setEmail(rs.getString("email"));
        return contact;

    }
}
