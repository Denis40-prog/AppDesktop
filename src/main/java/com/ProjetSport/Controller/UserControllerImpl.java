package com.ProjetSport.Controller;

import com.ProjetSport.model.User;
import com.ProjetSport.repository.UserRepository;

public class UserControllerImpl implements UserController{
    UserRepository userRepository;

    public UserControllerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String saveUser(User user) {

        return this.userRepository.save(user);
    }
}
