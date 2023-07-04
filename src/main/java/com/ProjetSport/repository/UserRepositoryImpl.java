package com.ProjetSport.repository;

import com.ProjetSport.model.Activity;
import com.ProjetSport.model.User;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.ProjetSport.Mapper.UserMapper.documentToUser;
import static com.ProjetSport.Mapper.UserMapper.userToDocument;

public class UserRepositoryImpl implements UserRepository {
    MongoCollection<Document> collection;
    public UserRepositoryImpl(MongoClient mongoClient){
        this.collection = mongoClient.getDatabase("myActivities").getCollection("users");;
    }

    @Override
    public String save(User user) {
        InsertOneResult result = this.collection.insertOne(userToDocument(user));
        return Objects.requireNonNull(result.getInsertedId()).toString();
    }

    public Long delete(User user){
        DeleteResult result = this.collection.deleteOne(userToDocument(user));
        return result.getDeletedCount();
    }

    public long uptdate(User user){
        Document documentQuery = new Document();
        documentQuery.append(
                "_id",
                user.getId()
        );
        UpdateResult result = this.collection.updateOne(documentQuery, userToDocument(user));
        return result.getModifiedCount();
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        for (Document document : this.collection.find()) {
            users.add(documentToUser(document));
        }
        return users;
    }

    public User getById(ObjectId id) {
        Document documentQuery = new Document();
        documentQuery.append(
                "_id",
                id
        );
        Document result = this.collection.find(documentQuery).first();
        assert result != null;
        return documentToUser(result);
    }
}
