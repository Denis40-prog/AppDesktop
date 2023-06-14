import com.ProjetSport.GUI.Window;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Connection {
    public static void main(String[] args){
        getLog();
    }

    public static void getLog(){
        String connectionString = "mongodb+srv://denischevanne:IvqSyBAq8XEKXpeD@cluster0.r89stxe.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> log.info("Databases : {}", db.toJson()));
        }

        JFrame frame = new Window();
    }

}
