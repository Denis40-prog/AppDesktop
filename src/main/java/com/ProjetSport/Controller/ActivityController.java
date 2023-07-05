package com.ProjetSport.Controller;

import com.ProjetSport.model.Activity;
import com.ProjetSport.repository.ActivityRepository;
import com.ProjetSport.repository.ActivityRepositoryImpl;

import java.util.List;

public interface ActivityController {
    String saveActivity(Activity activity);

    List<Activity> findAll();
}

