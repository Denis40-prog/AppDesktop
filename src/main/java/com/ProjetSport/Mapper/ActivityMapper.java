package com.ProjetSport.Mapper;

import com.ProjetSport.model.Activity;
import org.bson.Document;

import java.sql.Date;

public class ActivityMapper {
    public static Document activityToDocument(Activity activity) {
        return new Document()
                .append("name", activity.getName())
                .append("duration", activity.getDuration())
                .append("rpe", activity.getRpe())
                .append("load", activity.getLoad())
                .append("date", activity.getDate())
                ;
    }
    public static Activity documentToActivity(Document document) {
        return new Activity(
                (String) document.get("name"),
                (Integer) document.get("duration"),
                (String) document.get("rpe"),
                (String) document.get("load"),
                (Date) document.get("date")
        );
    }
}
