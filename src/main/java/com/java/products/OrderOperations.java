package com.java.products;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Arrays;

public class OrderOperations {
    public static void insertOrders(MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("Orders");

        Document order1 = new Document("Order ID", "O001")
                .append("User ID", "U001")
                .append("Product Code", "PEN")
                .append("Quantity", 3)
                .append("Total", 3.69);

        Document order2 = new Document("Order ID", "O002")
                .append("User ID", "U002")
                .append("Product Code", "PEN-BLACK")
                .append("Quantity", 2)
                .append("Total", 2.5);

        collection.insertMany(Arrays.asList(order1, order2));
        System.out.println("✅ Orders inserted successfully");
    }
}
