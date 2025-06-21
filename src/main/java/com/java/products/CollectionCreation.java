package com.java.products;

import com.mongodb.client.MongoDatabase;

public class CollectionCreation {
    public static void createCollection(MongoDatabase database) {
        if (database != null) {
            try {
                database.createCollection("Products");
                System.out.println("Collection 'Products' created successfully");
            } catch (Exception e) {
                System.out.println("Collection 'Products' may already exist. Skipping creation.");
            }
        } else {
            System.err.println("Database connection is null. Collection creation failed.");
        }
    }
}
