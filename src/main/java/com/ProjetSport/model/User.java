package com.ProjetSport.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.Date;

@Getter
@Setter
public class User {

    private ObjectId id;
    @Setter
    private String name;
    @Setter
    private String lastName;
    @Setter
    private String birthdate;
    @Setter
    private String gender;

    public User(String name, String lastName, String birthdate, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
    }
}
