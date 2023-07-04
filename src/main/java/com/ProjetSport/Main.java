package com.ProjetSport;

import com.ProjetSport.Controller.ActivityControllerImpl;
import com.ProjetSport.GUI.Window;
import com.ProjetSport.repository.ActivityRepositoryImpl;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import javax.swing.*;

@Slf4j
public class Main {
    public static void main(String[] args)
    {
        Connection connexion = new Connection();
        JFrame frame = new Window(connexion);
    }
}
