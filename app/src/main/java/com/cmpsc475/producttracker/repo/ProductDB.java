///*
package com.cmpsc475.producttracker.repo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cmpsc475.producttracker.model.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDB extends RoomDatabase {
    public abstract ProductDao productDao();
}
//*/