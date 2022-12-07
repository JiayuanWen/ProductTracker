package com.cmpsc475.producttracker.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.cmpsc475.producttracker.ProductListAdapter;
import com.cmpsc475.producttracker.ProductListViewModel;
import com.cmpsc475.producttracker.R;
import com.cmpsc475.producttracker.model.Product;
import com.cmpsc475.producttracker.ui.list.ListFragment;
import com.cmpsc475.producttracker.ui.list.ListViewModel;

import java.util.ArrayList;

public class AboutFragment extends Fragment {
    private ListViewModel listViewModel;
    private ProductListViewModel mProductListViewModel;
    private ArrayList<Product> productArrayList;
    private String[] productTitle;
    private int[] imageResourceID;
    private RecyclerView recyclerview;
    private ProductListAdapter listAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_about, container, false);



        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(view, saveInstanceState);

    }
}
