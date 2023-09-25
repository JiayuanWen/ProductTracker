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


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Show About App fragment
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(view, saveInstanceState);

        // Back button handle
        Button backButton;
        backButton = view.findViewById(R.id.back_to_list);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Return to product list
                //FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                //transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                //transaction.replace(R.id.nav_host_fragment, new ListFragment());
                //transaction.commit();
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                getActivity().getSupportFragmentManager().popBackStack();

            }
        });
    }
}
