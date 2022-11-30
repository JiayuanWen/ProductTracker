package com.cmpsc475.producttracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>{

    Context context;
    ArrayList<Product> productArrayList;
    public ProductListAdapter(Context context, ArrayList<Product> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
    }

    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.product_item_list,parent,false);

        return new ProductListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListViewHolder holder, int position) {

        Product product = productArrayList.get(position);

    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public static class ProductListViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView productTitle;


        public ProductListViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_name);
        }
    }
}
