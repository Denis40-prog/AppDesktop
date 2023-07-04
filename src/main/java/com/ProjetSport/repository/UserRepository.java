package com.ProjetSport.repository;

import com.ProjetSport.model.Activity;
import com.ProjetSport.model.User;

import java.util.List;

public interface UserRepository {
    String save(User user);

    List<Activity> getAll();
}
