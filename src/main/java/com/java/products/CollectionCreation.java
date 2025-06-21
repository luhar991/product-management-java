package com.java.products;

import com.mongodb.client.MongoDatabase;

public class CollectionCreation {

    public static void createCollections(MongoDatabase database) {
        try {
            database.createCollection("Products");
            database.createCollection("Categories");
            database.createCollection("Users");
            database.createCollection("Orders");
            database.createCollection("Reviews");

            System.out.println("✅ All collections created successfully.");
        } catch (Exception e) {
            System.out.println("⚠️ Collections may already exist: " + e.getMessage());
        }
    }
}



