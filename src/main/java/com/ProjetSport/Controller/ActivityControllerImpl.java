package com.ProjetSport.Controller;

import com.ProjetSport.model.Activity;
import com.ProjetSport.repository.ActivityRepository;

import java.util.List;

public class ActivityControllerImpl implements ActivityController {
    ActivityRepository activityRepository;

    public ActivityControllerImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public String saveActivity(Activity activity) {
        return this.activityRepository.save(activity);
    }
    @Override
    public List<Activity> findAll(){
        return this.activityRepository.getAll();
    }
}
