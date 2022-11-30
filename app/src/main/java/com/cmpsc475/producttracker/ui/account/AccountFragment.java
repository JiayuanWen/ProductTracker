package com.cmpsc475.producttracker.ui.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.cmpsc475.producttracker.R;

public class AccountFragment extends Fragment {

    private AccountViewModel accountViewModelViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountViewModelViewModel =
                ViewModelProviders.of(this).get(AccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_account, container, false);
        return root;
    }
}