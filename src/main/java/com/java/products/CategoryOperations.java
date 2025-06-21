package com.java.products;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Arrays;

public class CategoryOperations {
    public static void insertCategories(MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("Categories");

        Document cat1 = new Document("Category ID", "C001")
                .append("Name", "Stationery")
                .append("Description", "Items like pens, pencils, and paper.");

        Document cat2 = new Document("Category ID", "C002")
                .append("Name", "Electronics")
                .append("Description", "Electronic items like USBs and chargers.");

        collection.insertMany(Arrays.asList(cat1, cat2));
        System.out.println("✅ Categories inserted successfully");
    }
}
