package com.cmpsc475.producttracker.ui.list;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.ViewModelProvider;

import com.cmpsc475.producttracker.ProductListAdapter;
import com.cmpsc475.producttracker.ProductListViewModel;
import com.cmpsc475.producttracker.R;
import com.cmpsc475.producttracker.model.Product;
import com.cmpsc475.producttracker.ui.add.AddProductFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    private ListViewModel listViewModel;
    private ProductListViewModel mProductListViewModel;
    private ArrayList<Product> productArrayList;
    private String[] productTitle;
    private int[] imageResourceID;
    private RecyclerView recyclerview;
    private ProductListAdapter listAdapter;

    public interface OnItemClickListener {
        void onDeleteClick(int position);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listViewModel =
                ViewModelProviders.of(this).get(ListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_list, container, false);

        mProductListViewModel = new ViewModelProvider(this).get(ProductListViewModel.class);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(view, saveInstanceState);

        productArrayList = new ArrayList<>();

        recyclerview = view.findViewById(R.id.product_list);

        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);

        listAdapter = new ProductListAdapter(getContext(),productArrayList,mProductListViewModel);
        recyclerview.setAdapter(listAdapter);

        listAdapter.setOnItemClickListener(new ProductListAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(int position) {
                Product removeTarget = productArrayList.get(position);
                Log.d("ListFragment:", String.valueOf(removeTarget));
                mProductListViewModel.deleteProduct(removeTarget);
            }

            @Override
            public void onDeleteClick(int position) {
                Product removeTarget = productArrayList.get(position);
                Log.d("ListFragment:", String.valueOf(removeTarget));
                mProductListViewModel.deleteProduct(removeTarget);
            }
        });


        mProductListViewModel.getProducts().observe(getViewLifecycleOwner(), products -> {

            productArrayList = (ArrayList<Product>) products;

            ProductListAdapter listAdapter = new ProductListAdapter(getContext(),productArrayList,mProductListViewModel);
            recyclerview.setAdapter(listAdapter);
            listAdapter.notifyDataSetChanged();
        });

        FloatingActionButton addProduct = view.findViewById(R.id.add_product_button);
        addProduct.show();
        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct.hide();

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                transaction.replace(R.id.fragment_addProduct, new AddProductFragment());
                transaction.commit();
            }
        });



    }

}