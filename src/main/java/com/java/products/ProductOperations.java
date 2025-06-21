package com.java.products;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

public class ProductOperations {
    public static void insertProducts(MongoDatabase database) {
        if (database != null) {
            MongoCollection<Document> collection;

            boolean collectionExists = database.listCollectionNames()
                    .into(new java.util.ArrayList<>())
                    .contains("Products");

            if (!collectionExists) {
                database.createCollection("Products");
                System.out.println("Collection 'Products' created.");
            }

            collection = database.getCollection("Products");

            if (collection.countDocuments() == 0) {
                Document[] products = {
                    new Document("Product Code", "PEN").append("Product Name", "Pen Red").append("Quantity", 5000).append("Price (USD)", 1.23),
                    new Document("Product Code", "PEN").append("Product Name", "Pen Blue").append("Quantity", 8000).append("Price (USD)", 1.25),
                    new Document("Product Code", "PEN").append("Product Name", "Pen Black").append("Quantity", 2000).append("Price (USD)", 1.25),
                    new Document("Product Code", "PEC").append("Product Name", "Pencil 2B").append("Quantity", 10000).append("Price (USD)", 0.48),
                    new Document("Product Code", "PEC").append("Product Name", "Pencil 2H").append("Quantity", 8000).append("Price (USD)", 0.49)
                };

                collection.insertMany(Arrays.asList(products));
                System.out.println("Products inserted successfully");
            } else {
                System.out.println("Products already exist. Skipping insertion.");
            }
        } else {
            System.err.println("Database connection is null. Data insertion failed.");
        }
    }
}



