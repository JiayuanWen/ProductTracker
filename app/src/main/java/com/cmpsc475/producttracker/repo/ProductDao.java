///*
package com.cmpsc475.producttracker.repo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.cmpsc475.producttracker.model.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM Product WHERE id = :id")//LiveData<Product> getProduct(long id);
    LiveData<Product> getProduct(long id);

    @Query("SELECT * FROM Product ORDER BY name COLLATE NOCASE")
    LiveData<List<Product>> getProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addProduct(Product product);

    @Update
    void updateProduct(Product product);

    @Delete
    void deleteProduct(Product productID);
}
//*/