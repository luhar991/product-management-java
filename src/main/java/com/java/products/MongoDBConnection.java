package com.java.products;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    // 🔑 Hardcoded connection string — replace with your actual credentials
    private static final String CONNECTION_STRING = "mongodb+srv://mongoUser:spiderman@cluster0.dqxyh7x.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String DATABASE_NAME = "products";

    public static MongoDatabase connect() {
        try {
            MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
            System.out.println("✅ Connected to MongoDB successfully");
            return mongoClient.getDatabase(DATABASE_NAME);
        } catch (Exception e) {
            System.err.println("❌ Connection failed: " + e.getMessage());
            return null;
        }
    }
}






