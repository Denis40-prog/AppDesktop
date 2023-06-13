package com.ProjetSport.Controller;

import com.ProjetSport.model.Activity;
import com.ProjetSport.repository.ActivityRepository;

public interface ActivityController {
    String saveActivity(Activity activity);
}

