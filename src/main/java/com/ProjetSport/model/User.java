package com.ProjetSport.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {

    private String name;
    private String lastName;
    private Date birthdate;
    private String gender;

    public User(String name, String lastName, Date birthdate, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
    }
}
