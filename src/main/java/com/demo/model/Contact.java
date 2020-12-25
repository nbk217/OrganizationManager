package com.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Contact {
    private int id;
    private String name;
    private String mobile;
    private String secondaryMobile;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name) &&
                mobile.equals(contact.mobile) &&
                email.equals(contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
