package com.ProjetSport.Mapper;

import com.ProjetSport.model.Activity;
import org.bson.Document;

public class ActivityMapper {
    public static Activity activityToDocument(Activity activity) {
        return new Activity()
                .append("name", activity.getName())
                .append("date", activity.getDate())
                .append("load", activity.getLoad())
                .append("rpe", activity.getRpe())
                .append("duration", activity.getDuration());
    }
}
