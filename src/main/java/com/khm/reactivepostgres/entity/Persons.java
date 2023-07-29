package com.khm.reactivepostgres.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
public class Persons {
    @Id
    private int id;
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column("phone_number")
    private String phoneNumber;

    public Persons() {

    }

    public Persons(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Persons [id=" + id + ", firstname=" + firstName + ", lastname=" + lastName + ", phonenumber=" + phoneNumber + "]";
    }

}

