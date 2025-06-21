package com.java.products;

import com.mongodb.client.MongoDatabase;

public class DataInsertion {

    public static void insertAllData(MongoDatabase database) {
        ProductOperations.insertProducts(database);
        CategoryOperations.insertCategories(database);
        UserOperations.insertUsers(database);
        OrderOperations.insertOrders(database);
        ReviewOperations.insertReviews(database);
    }
}

