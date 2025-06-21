package com.java.products;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Arrays;

public class UserOperations {
    public static void insertUsers(MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("Users");

        Document user1 = new Document("User ID", "U001")
                .append("Name", "Rahul Cherukuri")
                .append("Email", "rahul@example.com");

        Document user2 = new Document("User ID", "U002")
                .append("Name", "Jane Doe")
                .append("Email", "jane@example.com");

        collection.insertMany(Arrays.asList(user1, user2));
        System.out.println("✅ Users inserted successfully");
    }
}
