package com.ProjetSport;

import com.ProjetSport.Controller.ActivityController;
import com.ProjetSport.Controller.ActivityControllerImpl;
import com.ProjetSport.Controller.UserController;
import com.ProjetSport.Controller.UserControllerImpl;
import com.ProjetSport.GUI.register_window;
import com.ProjetSport.repository.ActivityRepository;
import com.ProjetSport.repository.ActivityRepositoryImpl;
import com.ProjetSport.repository.UserRepository;
import com.ProjetSport.repository.UserRepositoryImpl;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

@Slf4j
public class Main {
    public static void main(String[] args)
    {
        Connection connexion = new Connection();
        connexion.connect();
        ActivityRepository activityRepo = new ActivityRepositoryImpl(connexion.getMongoClient());
        ActivityController activityCtrl = new ActivityControllerImpl(activityRepo);
        UserRepository userRepository = new UserRepositoryImpl(connexion.getMongoClient());
        UserController userController = new UserControllerImpl(userRepository);
        JFrame frame = new register_window(activityCtrl, userController);
    }
}
