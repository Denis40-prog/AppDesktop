package com.ProjetSport.Mapper;
import com.ProjetSport.model.Activity;
import com.ProjetSport.model.User;
import org.bson.Document;

import java.sql.Date;

public class UserMapper {

    public static Document userToDocument(User user) {
        return new Document()
                .append("name", user.getName())
                .append("lastName", user.getLastName())
                .append("birthDate", user.getBirthdate())
                .append("gender", user.getGender())
                ;
    }
    public static User documentToUser(Document document) {
        return new User(
                (String) document.get("name"),
                (String) document.get("lastName"),
                (String) document.get("gender"),
                (String) document.get("birthDate")
        );
    }
}
