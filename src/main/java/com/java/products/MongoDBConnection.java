package com.java.products;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoDBConnection {
    // ✅ Replaced hardcoded URI with environment variable for cloud deployment
    private static final String CONNECTION_STRING = System.getenv("MONGO_URI");
    private static final String DATABASE_NAME = "product";

    public static MongoDatabase connect() {
        try {
            MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
            System.out.println("Connected to MongoDB successfully");
            return mongoClient.getDatabase(DATABASE_NAME);
        } catch (Exception e) {
            System.err.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
}

class CollectionCreation {
    public static void createCollection(MongoDatabase database) {
        if (database != null) {
            database.createCollection("Products");
            System.out.println("Collection 'Products' created successfully");
        } else {
            System.err.println("Database connection is null. Collection creation failed.");
        }
    }
}

class DataInsertion {
    public static void insertProducts(MongoDatabase database) {
        if (database != null) {
            MongoCollection<Document> collection = database.getCollection("Products");
            Document[] products = {
                new Document("Product Code", "PEN").append("Product Name", "Pen Red").append("Quantity", 5000).append("Price (USD)", 1.23),
                new Document("Product Code", "PEN").append("Product Name", "Pen Blue").append("Quantity", 8000).append("Price (USD)", 1.25),
                new Document("Product Code", "PEN").append("Product Name", "Pen Black").append("Quantity", 2000).append("Price (USD)", 1.25),
                new Document("Product Code", "PEC").append("Product Name", "Pencil 2B").append("Quantity", 10000).append("Price (USD)", 0.48),
                new Document("Product Code", "PEC").append("Product Name", "Pencil 2H").append("Quantity", 8000).append("Price (USD)", 0.49)
            };
            collection.insertMany(java.util.Arrays.asList(products));
            System.out.println("Products inserted successfully");
        } else {
            System.err.println("Database connection is null. Data insertion failed.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        MongoDatabase database = MongoDBConnection.connect();
        CollectionCreation.createCollection(database);
        DataInsertion.insertProducts(database);
    }
}

