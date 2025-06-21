package com.java.products;

import com.mongodb.client.MongoDatabase;

public class Main {
    public static void main(String[] args) {
        MongoDatabase database = MongoDBConnection.connect();
        CollectionCreation.createCollection(database);
        DataInsertion.insertProducts(database);
    }
}
