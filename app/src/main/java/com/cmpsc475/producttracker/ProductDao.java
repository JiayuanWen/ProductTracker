package com.cmpsc475.producttracker;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM Product WHERE id = :id")
    Product getProduct(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addProduct(Product product);

    @Update
    void updateProduct(Product product, int newYear, int newMonth, int newDay);

    @Delete
    void deleteProduct(Product product);
}
