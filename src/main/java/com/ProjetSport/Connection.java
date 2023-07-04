package com.ProjetSport;

import com.ProjetSport.Controller.ActivityController;
import com.ProjetSport.Controller.ActivityControllerImpl;
import com.ProjetSport.GUI.Window;
import com.ProjetSport.repository.ActivityRepository;
import com.ProjetSport.repository.ActivityRepositoryImpl;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import javax.print.Doc;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Connection {
    @Getter
    private MongoClient mongoClient;

    public void connect(){
        String connectionString = "mongodb+srv://denischevanne:IvqSyBAq8XEKXpeD@cluster0.r89stxe.mongodb.net/?retryWrites=true&w=majority";
        this.mongoClient = MongoClients.create(connectionString);
    }

    public void close(){
        this.mongoClient.close();
    }

}
