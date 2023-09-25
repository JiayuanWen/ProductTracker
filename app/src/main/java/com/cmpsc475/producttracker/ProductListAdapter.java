package com.cmpsc475.producttracker;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.cmpsc475.producttracker.model.Product;
import com.cmpsc475.producttracker.ui.list.ListFragment;

import java.util.ArrayList;
import java.util.Calendar;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>{

    private Context context;
    private ArrayList<Product> productArrayList;
    private OnItemClickListener mListener;
    private ProductListViewModel mProductListViewModel;


    public ProductListAdapter(Context context, ArrayList<Product> productArrayList, ProductListViewModel mProductListViewModel) {
        this.context = context;
        this.productArrayList = productArrayList;
        this.mProductListViewModel = mProductListViewModel;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener clickListener) {mListener = clickListener;};

    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.product_item_list,parent,false);

        return new ProductListViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListViewHolder holder, int position) {
        Product product = productArrayList.get(position);
        holder.productTitle.setText(product.getProductName());
        holder.productImage.setImageResource(product.getProductImage());

        Calendar calendar = Calendar.getInstance();

        // Time since owned
        int dayBought = product.getDay();
        int yearBought = product.getYear();
        int monthBought = product.getMonth();

        int yearCurrent = calendar.get(Calendar.YEAR);
        int monthCurrent = calendar.get(Calendar.MONTH);
        int dayCurrent = calendar.get(Calendar.DAY_OF_MONTH);

        int yearDiff = (yearCurrent - yearBought);
        int monthDiff = monthCurrent - monthBought;
        int dayDiff = dayCurrent - dayBought;
        if (monthDiff < 0) {
            yearDiff--;
            monthDiff = 12 + monthDiff;
        }

        if (
                monthBought == 1 ||
                        monthBought == 3 ||
                        monthBought == 5 ||
                        monthBought == 7 ||
                        monthBought == 8 ||
                        monthBought == 10 ||
                        monthBought == 12
        ) {
            if (dayDiff <= 0) {
                monthBought--;
                dayDiff = 31 + dayDiff;
            }
        }
        if (
                monthBought == 4 ||
                        monthBought == 6 ||
                        monthBought == 9 ||
                        monthBought == 11
        ) {
            if (dayDiff <= 0) {
                monthBought--;
                dayDiff= 30 + dayDiff;
            }
        }

        if (yearBought % 400 == 0) {
            if (monthBought == 2) {
                if (dayDiff <= 0) {
                    monthBought--;
                    dayDiff = 29 + dayDiff;
                }
            }
        } else if (yearBought % 100 == 0) {
            if (monthBought == 2) {
                if (dayDiff <= 0) {
                    monthBought--;
                    dayDiff = 28 + dayDiff;
                }
            }
        } else if (yearBought % 4 == 0) {
            if (monthBought == 2) {
                if (dayBought <= 0) {
                    monthBought--;
                    dayDiff = 29 + dayDiff;
                }
            } else {
                if (monthBought == 2) {
                    if (dayDiff <= 0) {
                        monthBought--;
                        dayDiff = 28 + dayDiff;
                    }
                }
            }
        }

        holder.purchasedTime.setText(yearDiff+" Years, "+monthDiff+" months, "+dayDiff+" days");

        // Time til warranty expire
        int dayExpire = product.getDayExp();
        int yearExpire = product.getYearExp();
        int monthExpire = product.getMonthExp();

        yearCurrent = calendar.get(Calendar.YEAR);
        monthCurrent = calendar.get(Calendar.MONTH);
        dayCurrent = calendar.get(Calendar.DAY_OF_MONTH);
                                               // We're doing differences, so no negatives
        yearDiff = (yearExpire - yearCurrent); if (yearDiff < 0) {yearDiff = yearDiff * -1;};
        monthDiff = (monthExpire - monthCurrent); if (monthDiff < 0) {monthDiff = monthDiff * -1;};
        dayDiff = (dayExpire - dayCurrent); if (dayDiff < 0) {dayDiff = dayDiff * -1;};
        if (monthDiff < 0) {
            yearDiff--;
            monthDiff = 12 + monthDiff;
        }

        if (
                monthBought == 1 ||
                        monthBought == 3 ||
                        monthBought == 5 ||
                        monthBought == 7 ||
                        monthBought == 8 ||
                        monthBought == 10 ||
                        monthBought == 12
        ) {
            if (dayDiff <= 0) {
                monthBought--;
                dayDiff = 31 + dayDiff;
            }
        }
        if (
                monthBought == 4 ||
                        monthBought == 6 ||
                        monthBought == 9 ||
                        monthBought == 11
        ) {
            if (dayDiff <= 0) {
                monthBought--;
                dayDiff= 30 + dayDiff;
            }
        }

        if (yearBought % 400 == 0) {
            if (monthBought == 2) {
                if (dayDiff <= 0) {
                    monthBought--;
                    dayDiff = 29 + dayDiff;
                }
            }
        } else if (yearBought % 100 == 0) {
            if (monthBought == 2) {
                if (dayDiff <= 0) {
                    monthBought--;
                    dayDiff = 28 + dayDiff;
                }
            }
        } else if (yearBought % 4 == 0) {
            if (monthBought == 2) {
                if (dayBought <= 0) {
                    monthBought--;
                    dayDiff = 29 + dayDiff;
                }
            } else {
                if (monthBought == 2) {
                    if (dayDiff <= 0) {
                        monthBought--;
                        dayDiff = 28 + dayDiff;
                    }
                }
            }
        }

        holder.warrantyExpireTime.setText(yearDiff+" Years, "+monthDiff+" months, "+dayDiff+" days");

        if (dayExpire == -99999 && yearExpire == -99999 && monthExpire == -99999) {
            holder.warrantyExpireTime.setText("N/A");
            return;
        }
        if (dayDiff <= 0 && yearDiff <= 0 && monthDiff <= 0) {
            holder.warrantyExpireTime.setText("Expired");
            return;
        }
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class ProductListViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView productTitle;

        TextView purchasedTime;
        TextView warrantyExpireTime;

        TextView purchasedYear;
        TextView purchasedMonth;
        TextView purchasedDay;



        Button deleteProduct;

        public ProductListViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_name);

            purchasedTime = itemView.findViewById(R.id.product_time);

            warrantyExpireTime = itemView.findViewById(R.id.warranty_time);

            /*
            purchasedYear = itemView.findViewById(R.id.year_bought);
            purchasedMonth = itemView.findViewById(R.id.month_bought);
            purchasedDay = itemView.findViewById(R.id.day_bought);
            // */

            deleteProduct = itemView.findViewById(R.id.delete_product);
            deleteProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getPosition();
                    Log.d("Adapter", String.valueOf(pos));
                    Log.d("ProductListAdapter:", String.valueOf(productArrayList));
                    mProductListViewModel.deleteProduct(productArrayList.get(pos));

                    if (listener != null) {
                        if (pos != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(pos);

                        }
                    }
                }
            });
        }
    }


}
