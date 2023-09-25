package com.cmpsc475.producttracker.repo;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.cmpsc475.producttracker.R;
import com.cmpsc475.producttracker.model.Product;

import java.util.List;

public class ProductRepo {

    private static ProductRepo mProductRepo;
    private final ProductDao mProductDao;

    public static ProductRepo getInstance(Context context) {
        if (mProductRepo == null) {
            mProductRepo = new ProductRepo(context);
        }
        return mProductRepo;
    }

    private ProductRepo(Context context) {
        ProductDB database = Room.databaseBuilder(context, ProductDB.class, "product.db")
                .allowMainThreadQueries()
                .build();

        mProductDao = database.productDao();

        //addSampleData();
    }

    /*
    Product prod1 = new Product("Seagate 4TB HDD",R.drawable.seagate4tb,2014,8,12);
        productArrayList.add(prod1);
    Product prod2 = new Product("SanDisk 32GB USB",R.drawable.image_placeholder,2014,8,12);
        productArrayList.add(prod2);
    Product prod3 = new Product("Nvidia RTX 3080 GPU",R.drawable.rtx3080,2014,8,12);
        productArrayList.add(prod3);
    Product prod4 = new Product("Toshiba 2TB HDD",R.drawable.image_placeholder,2014,8,12);
        productArrayList.add(prod4);
    //*/
    public void addSampleData() {
        Product prod1 = new Product("Seagate 4TB HDD", R.drawable.seagate4tb,2014,8,12,0,0,0);
        mProductDao.addProduct(prod1);

    }

    public void addProduct(Product product) {
        long productID = mProductDao.addProduct(product);
        product.setProductID(productID);
    }

    public LiveData<Product> getProduct(long productID) {
        return mProductDao.getProduct(productID);
    }

    public LiveData<List<Product>> getProducts() {
        return mProductDao.getProducts();
    }

    public void deleteProduct(Product product) {
        mProductDao.deleteProduct(product);
    }

    public void updateProduct(Product product) {
        mProductDao.updateProduct(product);
    }
}
