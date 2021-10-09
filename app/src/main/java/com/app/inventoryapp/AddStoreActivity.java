package com.app.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddStoreActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.addStoreButton) Button mAddStoreButton;
    @BindView(R.id.shopNameEditText) EditText mShopNameEditText;
    @BindView(R.id.locationEditText) EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_store);
        ButterKnife.bind(this);

        mAddStoreButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == mAddStoreButton){
            Intent intent = new Intent(AddStoreActivity.this, AddStoreAdminActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}