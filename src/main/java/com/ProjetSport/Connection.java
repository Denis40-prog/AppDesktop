package com.ProjetSport;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

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
