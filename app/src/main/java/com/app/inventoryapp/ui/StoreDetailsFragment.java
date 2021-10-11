package com.app.inventoryapp.ui;

import android.app.GameManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.inventoryapp.R;
import com.app.inventoryapp.models.Store;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

public class StoreDetailsFragment extends Fragment {

    private static final String TAG = "StoreDetailsFragment ";
    private BottomNavigationView bottomNavigationView;

    private TextView storeProducts;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        storeProducts = (TextView) storeProducts.findViewById(R.id.storeProducts);
//        storeProducts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store_details, container, false);

        initViews(view);
        initBottomNavigation();

        Utils utils = new Utils();
        utils.initDatabase(getActivity());

        return view;
    }

    private void initBottomNavigation() {
        Log.d(TAG, "initBottomNavigation: selected");
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.search:
                        Toast.makeText(getActivity(), "Search selected", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.home:
                        Toast.makeText(getActivity(), "Home selected", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.Clerk:
                        Toast.makeText(getActivity(), "Clerk selected", Toast.LENGTH_SHORT).show();

                        break;
                    default:
                        break;

                }
                return true;
            }
        });
    }

    private void initViews(View view) {
        Log.d(TAG,"initViews: started");
        bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.bottomNavigationView);
    }
}