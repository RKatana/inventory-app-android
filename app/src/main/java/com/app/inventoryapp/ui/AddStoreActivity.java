package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.inventoryapp.Constants;
import com.app.inventoryapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddStoreActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.addStoreButton) Button mAddStoreButton;
    @BindView(R.id.shopNameEditText) EditText mShopNameEditText;
    @BindView(R.id.locationEditText) EditText mLocationEditText;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_store);
        ButterKnife.bind(this);

        mAddStoreButton.setOnClickListener(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

    }

    @Override
    public void onClick(View view) {
        if(view == mAddStoreButton){
            String storeName = mShopNameEditText.getText().toString();
            Intent intent = new Intent(AddStoreActivity.this, AddStoreAdminActivity.class);
            addToSharedPreferences(storeName);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Added SuccessFul",Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private void addToSharedPreferences(String storeName){
        mEditor.putString(Constants.PREFERENCES_STORE_KEY,storeName).apply();
    }
}