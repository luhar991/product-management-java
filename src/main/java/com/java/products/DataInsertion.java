package com.java.products;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DataInsertion {
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
