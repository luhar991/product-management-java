package com.java.products;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class CollectionSetup {

    public static void createCollections(MongoDatabase database) {
        // Create Products collection
        if (collectionNotExists(database, "Products"))
            database.createCollection("Products");

        // Create Categories collection
        if (collectionNotExists(database, "Categories"))
            database.createCollection("Categories");

        // Create Users collection
        if (collectionNotExists(database, "Users"))
            database.createCollection("Users");

        // Create Orders collection
        if (collectionNotExists(database, "Orders"))
            database.createCollection("Orders");

        // Create Reviews collection
        if (collectionNotExists(database, "Reviews"))
            database.createCollection("Reviews");

        System.out.println("✅ All required collections created successfully.");
    }

    private static boolean collectionNotExists(MongoDatabase database, String collectionName) {
        for (String name : database.listCollectionNames()) {
            if (name.equalsIgnoreCase(collectionName)) {
                return false;
            }
        }
        return true;
    }
}

