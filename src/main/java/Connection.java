import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

public class Connection {
    private static final Logger logger = LoggerFactory.getLogger(Connection.class);
    public static void main(String[] args){
        getLog();
    }

    public static void getLog(){
        String connectionString = "mongodb+srv://denischevanne:IvqSyBAq8XEKXpeD@cluster0.r89stxe.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> logger.info("Databases : {}", db.toJson()));
        }
    }



}
