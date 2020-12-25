package com.demo.repository;

import com.demo.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PhonebookJdbc {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource() {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }



    public List<Contact> getContactDetails(){
        String sql= "select * from contact_info";
        List<Contact> contactList= jdbcTemplateObject.query(sql, new ContactMapper());
        return contactList;
    }

    public void saveContact(Contact inputcontact) {
        String sql= "insert into contact_info(name,phone1,phone2,email) values ( '"+inputcontact.getName()+"','"+inputcontact.getMobile()+"','"+inputcontact.getSecondaryMobile()+"','"+inputcontact.getEmail()+"')";
        System.out.println(sql);
        jdbcTemplateObject.execute(sql);
    }

    public void removeContact(String contactId) {
        String sql= "Delete from contact_info where id="+ contactId;
        jdbcTemplateObject.execute(sql);
    }
}
