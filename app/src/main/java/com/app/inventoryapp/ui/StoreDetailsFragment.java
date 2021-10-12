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

import org.parceler.Parcels;

public class StoreDetailsFragment extends Fragment {

    private static final String TAG = "StoreDetailsFragment ";
    private BottomNavigationView bottomNavigationView;

    private TextView storeName;
    private TextView storeLocation;


    private Store mStores;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store_details, container, false);
        getActivity().setTitle("Home");

        initViews(view);
        initBottomNavigation();


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
                        Intent intent = new Intent(getActivity(), StoresDashboardActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

                        break;
                    case R.id.home:
                        Toast.makeText(getActivity(), "Home selected", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.Clerk:
                        Intent clerkIntent = new Intent(getActivity(), ProductsActivity.class);
                        clerkIntent .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(clerkIntent );

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