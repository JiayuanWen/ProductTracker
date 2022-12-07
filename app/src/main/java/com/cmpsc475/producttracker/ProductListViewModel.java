package com.cmpsc475.producttracker;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cmpsc475.producttracker.model.Product;
import com.cmpsc475.producttracker.repo.ProductRepo;

import java.util.List;

public class ProductListViewModel extends AndroidViewModel {

    private final ProductRepo mProductRepo;

    public ProductListViewModel(Application application) {
        super(application);
        mProductRepo = ProductRepo.getInstance(application.getApplicationContext());
    }

    public LiveData<List<Product>> getProducts() {
        return mProductRepo.getProducts();
    }

    public void addProduct(Product product) {
        mProductRepo.addProduct(product);
    }

    public void deleteProduct(Product product) {
        mProductRepo.deleteProduct(product);
    }
}
// */