package com.ProjetSport.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.Date;

@Getter
@Setter
public class User {

    private ObjectId id;
    private String name;
    private String lastName;
    private String birthdate;
    private String gender;

    public User(String name, String lastName, String birthdate, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
    }
}
