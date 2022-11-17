package com.cmpsc475.producttracker.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cmpsc475.producttracker.MainActivity;
import com.cmpsc475.producttracker.ProductData;
import com.cmpsc475.producttracker.ProductDateAdapter;
import com.cmpsc475.producttracker.R;

public class ListFragment extends Fragment {

    private ListViewModel listViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState, MainActivity activity) {
        listViewModel =
                ViewModelProviders.of(this).get(ListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        final TextView textView = root.findViewById(R.id.product_list_title);
        listViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        RecyclerView recyclerView = root.findViewById(R.id.product_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        //For testint recycler list view, comment out in final release.
        ProductData[] productData = new ProductData[]{
                new ProductData("Seagate 4TB Drive",R.drawable.image_placeholder,2014,8,12),
                new ProductData("Seagate 4TB Drive",R.drawable.image_placeholder,2014,8,12),
                new ProductData("Seagate 4TB Drive",R.drawable.image_placeholder,2014,8,12),
        };

        ProductDateAdapter productDateAdapter = new ProductDateAdapter(productData, activity);
        recyclerView.setAdapter(productDateAdapter);

        return root;
    }
}