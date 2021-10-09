package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.app.inventoryapp.R;
import com.app.inventoryapp.adapter.StoreListAdapter;
import com.app.inventoryapp.models.Store;

import java.util.ArrayList;

public class StoresDashboardActivity extends AppCompatActivity {
    private static final String TAG = "StoresDashboardActivity";
    private RecyclerView storeRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores_dashboard);
        Log.d(TAG,"onCreate: Started");

        storeRecyclerView = (RecyclerView) findViewById(R.id.storeRecyclerView);
        StoreListAdapter adapter = new StoreListAdapter(this);
        storeRecyclerView.setAdapter(adapter);
        storeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Store> stores = new ArrayList<>();

        stores.add(new Store("Store One","Nairobi Karen"));
        stores.add(new Store("Store Two","Kenya"));
        stores.add(new Store("Store Three","Karen"));
        stores.add(new Store("Store Four","Samburu"));
        stores.add(new Store("Store Five","Ngon"));
        stores.add(new Store("Store Six","Karen"));
        stores.add(new Store("Store Six","Karen"));
        stores.add(new Store("Store Six","Karen"));
        stores.add(new Store("Store Six","Karen"));
        stores.add(new Store("Store Six","Karen"));

        adapter.setStores(stores);
    }
}