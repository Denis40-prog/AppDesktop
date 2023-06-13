package com.ProjetSport.repository;

import com.ProjetSport.model.Activity;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;

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

    public Long delete(Activity activity){
        DeleteResult result = this.collection.deleteOne(activityToDocument(activity));
        return result.getDeletedCount();
    }

    public long uptdate(Activity activity){
        Document documentQuery = new Document();
        documentQuery.append(
                "_id",
                activity.getId()
        );
        UpdateResult result = this.collection.updateOne(documentQuery, activityToDocument(activity));
        return result.getModifiedCount();
    }

    @Override
    public List<Activity> getAll() {
        List<Activity> activities = new ArrayList<>();
        for (Document document : this.collection.find()) {
            activities.add(documentToActivity(document));
        }
        return activities;
    }

    public Activity getById(ObjectId id) {
        Document documentQuery = new Document();
        documentQuery.append(
                "_id",
                id
        );
        Document result = this.collection.find(documentQuery).first();
        assert result != null;
        return documentToActivity(result);
    }
}

