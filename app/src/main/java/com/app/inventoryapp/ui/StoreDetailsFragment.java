package com.app.inventoryapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.inventoryapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StoreDetailsFragment extends Fragment {

    private static final String TAG = "StoreDetailsFragment ";
    private BottomNavigationView bottomNavigationView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store_details, container, false);

        initView(view);
        initBottomNavigation();

        return view;
    }

    private void initView(View view) {
        Log.d(TAG,"initView: selected");
    }

    private void initBottomNavigation() {
        Log.d(TAG, "initBottomNavigation: selected");
//        bottomNavigationView.setSelectedItemId(R.id.home);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.search:
//
//                        break;
//                    case R.id.home:
//
//                        break;
//                    case R.id.Clerk:
//                        Toast.makeText(getActivity(), "Clerk selected", Toast.LENGTH_SHORT).show();
//
//                        break;
//                    default:
//                        break;
//
//                }
//                return true;
//            }
//        });
    }
}