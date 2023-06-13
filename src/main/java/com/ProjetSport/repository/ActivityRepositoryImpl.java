package com.ProjetSport.repository;

import com.ProjetSport.model.Activity;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import static com.ProjetSport.Mapper.ActivityMapper.activityToDocument;
import static com.ProjetSport.Mapper.ActivityMapper.documentToActivity;
import java.util.Objects;

public class ActivityRepositoryImpl implements ActivityRepository {
    MongoCollection<Document> collection;
    public ActivityRepositoryImpl(MongoCollection<Document> collection){
        this.collection = collection;
    }
    @Override
    public String save(Activity activity) {
        InsertOneResult result = this.collection.insertOne(activityToDocument(activity));
        return Objects.requireNonNull(result.getInsertedId()).toString();
    }

    @Override
    public List<Activity> getAll() {
        List<Activity> books = new ArrayList<Activity>();
        for (Document document : this.collection.find()) {
            books.add(documentToActivity(document));
        }
        return books;
    }
}

