package com.ProjetSport.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.awt.*;
import java.util.Date;
import java.util.Objects;

@Getter
public class Activity {

    private ObjectId id;
    @Setter
    private String name;
    @Setter
    private Integer duration;
    @Setter
    private Integer rpe;
    @Setter
    private Integer load;
    @Setter
    private Date date;

    /*public Activity(ObjectId id, String name, Integer duration, String rpe, String load, Date date) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.rpe = rpe;
        this.load = load;
        this.date = date;
    }*/
    public Activity(String name, Integer duration, Integer rpe, Integer load, Date date) {
        this.name = name;
        this.duration = duration;
        this.rpe = rpe;
        this.load = load;
        this.date = date;
    }
}
