package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.app.inventoryapp.R;
import com.app.inventoryapp.adapter.StoreListAdapter;
import com.app.inventoryapp.models.Store;

public class StoresDashboardActivity extends AppCompatActivity {
    private ImageView mImageView;
    StoreListAdapter Adapter;

    Store storeOne = new Store("Store One","Nairobi Karen");
    Store storeTwo = new Store("Store Two","Rongai");
    Store storeThree = new Store("Store Three","Ngong Town");

    Store[] stores = {storeOne, storeTwo, storeThree };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores_dashboard);

        mImageView = (ImageView) findViewById(R.id.imageView);

        Adapter = new StoreListAdapter(StoresDashboardActivity.this,stores);
    }
}