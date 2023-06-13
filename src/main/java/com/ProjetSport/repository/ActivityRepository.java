package com.ProjetSport.repository;

import com.ProjetSport.model.Activity;

import java.util.List;

public interface ActivityRepository {
    String save(Activity activity);

    List<Activity> getAll();
}
