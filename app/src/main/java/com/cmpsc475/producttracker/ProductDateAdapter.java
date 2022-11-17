package com.cmpsc475.producttracker;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductDateAdapter extends RecyclerView.Adapter<ProductDateAdapter.ViewHolder> {
    // Constructor

    ProductData[] productData;
    Context context;

    public ProductDateAdapter(ProductData[] productData, MainActivity activity) {
        this.productData = productData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ProductData productDataList = productData[position];
        holder.productImage.setImageResource(productDataList.getProductImage());
        holder.productName.setText(productDataList.getProductName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, productDataList.getProductName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productData.length;
    }
    // End of Constructor



    // Recycler View Holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName;

        TextView yearOwned;
        TextView monthOwned;
        TextView dayOwned;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
        }
    }
    // End of Recycler View Holder
}
