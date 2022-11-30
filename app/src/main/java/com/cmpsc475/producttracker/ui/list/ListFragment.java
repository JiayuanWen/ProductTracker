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
import com.cmpsc475.producttracker.ProductListAdapter;
import com.cmpsc475.producttracker.R;
import com.cmpsc475.producttracker.Product;
import java.util.ArrayList;

public class ListFragment extends Fragment {

    private ListViewModel listViewModel;
    private ArrayList<Product> productArrayList;
    private String[] productTitle;
    private int[] imageResourceID;
    private RecyclerView recyclerview;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
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


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(view, saveInstanceState);

        dataInitialize();

        recyclerview = view.findViewById(R.id.product_list);

        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);

        ProductListAdapter listAdapter = new ProductListAdapter(getContext(),productArrayList);
        recyclerview.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {

        productArrayList = new ArrayList<>();

        for (int i=0; i < 3; i++) {
            Product prod = new Product("Seagate 4TB Drive",R.drawable.image_placeholder,2014,8,12);
            productArrayList.add(prod);
        }

    }
}