package com.cmpsc475.producttracker.ui.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.ViewModelProvider;

import com.cmpsc475.producttracker.MainActivity;
import com.cmpsc475.producttracker.ProductListAdapter;
import com.cmpsc475.producttracker.ProductListViewModel;
import com.cmpsc475.producttracker.R;
import com.cmpsc475.producttracker.model.Product;
import com.cmpsc475.producttracker.ui.add.AddProductFragment;
import com.cmpsc475.producttracker.ui.list.ListFragment;
import com.cmpsc475.producttracker.ui.list.ListViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddProductFragment extends Fragment {
    private ListViewModel listViewModel;
    private ProductListViewModel mProductListViewModel;
    private ArrayList<Product> productArrayList;
    private String[] productTitle;
    private int[] imageResourceID;
    private RecyclerView recyclerview;
    private ProductListAdapter listAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_addproduct, container, false);

        mProductListViewModel = new ViewModelProvider(this).get(ProductListViewModel.class);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(view, saveInstanceState);

        Button confirmAdd;

        confirmAdd = view.findViewById(R.id.add_product_confirm);
        confirmAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text;


                text = (EditText) view.findViewById(R.id.product_name_entry);
                String productName = text.getText().toString();

                //If we have no warranty entered, set all to -99999
                int dayExpire = 0;
                text = (EditText) view.findViewById(R.id.day_expire);
                if (text.getText().toString().trim().length() <= 0) {
                    dayExpire = -99999;

                } else {
                    dayExpire = Integer.parseInt(text.getText().toString());
                }


                int yearExpire = 0;
                text = (EditText) view.findViewById(R.id.year_expire);
                if (text.getText().toString().trim().length() <= 0) {
                    yearExpire = -99999;

                } else {
                    yearExpire = Integer.parseInt(text.getText().toString());
                }

                int monthExpire = 0;
                text = (EditText) view.findViewById(R.id.month_expire);
                if (text.getText().toString().trim().length() <= 0) {
                    monthExpire = -99999;

                } else {
                    monthExpire = Integer.parseInt(text.getText().toString());
                }

                text = (EditText) view.findViewById(R.id.month_bought);
                if (text.getText().toString().trim().length() <= 0) { //Fail save
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                    transaction.replace(R.id.nav_host_fragment, new ListFragment());
                    transaction.commit();

                    Toast.makeText(getContext(),"Field(s) left blank, item not added.",Toast.LENGTH_LONG).show();

                    return;
                }
                int monthBought = Integer.parseInt(text.getText().toString());

                text = (EditText) view.findViewById(R.id.day_bought);
                if (text.getText().toString().trim().length() <= 0) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                    transaction.replace(R.id.nav_host_fragment, new ListFragment());
                    transaction.commit();

                    Toast.makeText(getContext(),"Field(s) left blank, item not added.",Toast.LENGTH_LONG).show();

                    return;
                }
                int dayBought = Integer.parseInt(text.getText().toString());

                text = (EditText) view.findViewById(R.id.year_bought);
                if (text.getText().toString().trim().length() <= 0) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                    transaction.replace(R.id.nav_host_fragment, new ListFragment());
                    transaction.commit();

                    Toast.makeText(getContext(),"Field(s) left blank, item not added",Toast.LENGTH_LONG).show();

                    return;
                }
                int yearBought = Integer.parseInt(text.getText().toString());

                //Date correction for purchase date
                if (
                        monthBought == 1 ||
                        monthBought == 3 ||
                        monthBought == 5 ||
                        monthBought == 7 ||
                        monthBought == 8 ||
                        monthBought == 10 ||
                        monthBought == 12
                ) {
                    if (dayBought > 31) {
                        monthBought++;
                        dayBought = dayBought - 31;
                    }
                }
                if (
                        monthBought == 4 ||
                        monthBought == 6 ||
                        monthBought == 9 ||
                        monthBought == 11
                ) {
                    if (dayBought > 30) {
                        monthBought++;
                        dayBought = dayBought - 30;
                    }
                }

                if (yearBought % 400 == 0) {
                    if (monthBought == 2) {
                        if (dayBought > 29) {
                            monthBought++;
                        }
                    }
                } else if (yearBought % 100 == 0) {
                    if (monthBought == 2) {
                        if (dayBought > 28) {
                            monthBought++;
                        }
                    }
                } else if (yearBought % 4 == 0) {
                    if (monthBought == 2) {
                        if (dayBought > 29) {
                            monthBought++;
                        }
                    }
                } else {
                    if (monthBought == 2) {
                        if (dayBought > 28) {
                            monthBought++;
                        }
                    }
                }

                //Date correction for warranty expiration
                if (monthExpire > 12) {
                    yearExpire++;
                    monthExpire = monthExpire - 12;
                }

                if (
                        monthExpire == 1 ||
                                monthExpire == 3 ||
                                monthExpire == 5 ||
                                monthExpire == 7 ||
                                monthExpire == 8 ||
                                monthExpire == 10 ||
                                monthExpire == 12
                ) {
                    if (dayExpire > 31) {
                        monthExpire++;
                        dayExpire = dayExpire - 31;
                    }
                }
                if (
                        monthExpire == 4 ||
                                monthExpire == 6 ||
                                monthExpire == 9 ||
                                monthExpire == 11
                ) {
                    if (dayExpire > 30) {
                        monthExpire++;
                        dayExpire = dayExpire - 30;
                    }
                }

                if (yearExpire % 400 == 0) {
                    if (monthExpire == 2) {
                        if (dayExpire > 29) {
                            monthExpire++;
                        }
                    }
                } else if (yearExpire % 100 == 0) {
                    if (monthExpire == 2) {
                        if (dayExpire > 28) {
                            monthExpire++;
                        }
                    }
                } else if (yearExpire % 4 == 0) {
                    if (monthExpire == 2) {
                        if (dayExpire > 29) {
                            monthExpire++;
                        }
                    }
                } else {
                    if (monthExpire == 2) {
                        if (dayExpire > 28) {
                            monthExpire++;
                        }
                    }
                }

                if (monthExpire > 12) {
                    yearExpire++;
                    monthExpire = monthExpire - 12;
                }


                Product newProduct;

                newProduct = new Product(productName,R.drawable.image_placeholder,yearBought,monthBought,dayBought,yearExpire,monthExpire,dayExpire);
                mProductListViewModel.addProduct(newProduct);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                transaction.replace(R.id.nav_host_fragment, new ListFragment());
                transaction.commit();

                Toast.makeText(getContext(),"Item added successfully",Toast.LENGTH_LONG).show();

                return;
            }
        });
    }
}
