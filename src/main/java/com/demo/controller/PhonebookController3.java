package com.demo.controller;

import com.demo.model.Contact;
import com.demo.repository.PhonebookJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhonebookController3 {

    @Autowired
    private PhonebookJdbc phonebookJdbc;

    private int id;

    @GetMapping("/phonebook3/all")
    public List<Contact> allContactDetails()  {

       return phonebookJdbc.getContactDetails();
    }

    @PostMapping("/phonebook3")
    public void saveContact(@RequestBody Contact inputContact){
        phonebookJdbc.saveContact(inputContact);
    }


    @DeleteMapping("/phonebook3/id/{id}")
    public void deleteContact(@PathVariable("id") String contactId){
        phonebookJdbc.removeContact(contactId);
    }

}

