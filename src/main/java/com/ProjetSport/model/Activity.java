package com.ProjetSport.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Activity {

    private String name;
    private Integer duration;
    private String rpe;
    private String load;
    private Date date;

    public Activity(String name, Integer duration, String rpe, String load, Date date) {
        this.name = name;
        this.duration = duration;
        this.rpe = rpe;
        this.load = load;
        this.date = date;
    }
}
