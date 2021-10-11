package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.app.inventoryapp.R;
import com.app.inventoryapp.adapter.ProductsListAdapter;
import com.app.inventoryapp.adapter.StoreListAdapter;
import com.app.inventoryapp.models.Store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoresDashboardActivity extends AppCompatActivity {
    private static final String TAG = "StoresDashboardActivity";
    @BindView(R.id.storeRecyclerView) RecyclerView mRecyclerView;

    Store store1 = new Store("Naivas Supermarket","Nairobi Karen");
    Store store2 = new Store("Bestmart supermarket","Kenya");
    Store store3 = new Store("Muthokinjo hardware","Karen");
    Store store4 = new Store("Grocery inn"," Ngong");
    Store store5 = new Store("Pizza inn ","Samburu");
    Store store6 = new Store("Chuma hardware","Kitengela");
    Store store7 = new Store("Kempiski restaurant","Don home");
    Store store8 = new Store("Electronics ltd","Ngara");

    private StoreListAdapter mAdapter;
    public List<Store> Stores = Arrays.asList(new Store[]{store1, store2, store3, store4, store5, store6, store7, store8});

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores_dashboard);

        ButterKnife.bind(this);

        mAdapter = new StoreListAdapter(Stores,this);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(StoresDashboardActivity.this, RecyclerView.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setVisibility(View.VISIBLE);


    }
}