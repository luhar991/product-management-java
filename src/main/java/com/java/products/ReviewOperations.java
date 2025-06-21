package com.java.products;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Arrays;

public class ReviewOperations {
    public static void insertReviews(MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("Reviews");

        Document review1 = new Document("Review ID", "R001")
                .append("Product Code", "PEN")
                .append("User ID", "U001")
                .append("Rating", 4)
                .append("Comment", "Writes smoothly.");

        Document review2 = new Document("Review ID", "R002")
                .append("Product Code", "PEN-BLACK")
                .append("User ID", "U002")
                .append("Rating", 5)
                .append("Comment", "Excellent quality!");

        collection.insertMany(Arrays.asList(review1, review2));
        System.out.println("✅ Reviews inserted successfully");
    }
}
