package com.java.products;

import com.mongodb.client.MongoDatabase;

public class Main {
    public static void main(String[] args) {
        MongoDatabase database = MongoDBConnection.connect();

        if (database != null) {
            // Step 1: Create all collections
            CollectionCreation.createCollections(database);

            // Step 2: Insert sample data into all collections
            DataInsertion.insertAllData(database);
        }
    }
}






