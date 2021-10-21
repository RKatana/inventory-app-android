package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.inventoryapp.Constants;
import com.app.inventoryapp.R;
import com.app.inventoryapp.models.AddStoreResponse;
import com.app.inventoryapp.models.RegisterUserResponse;
import com.app.inventoryapp.network.ApiClient;
import com.app.inventoryapp.network.ApiService;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddStoreActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.addStoreButton) Button mAddStoreButton;
    @BindView(R.id.shopNameEditText) EditText mShopNameEditText;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.ProgressBar) ProgressBar mProgressBar;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private AddStoreResponse addStoreResponse;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_store);
        ButterKnife.bind(this);

        mAddStoreButton.setOnClickListener(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        userId = mSharedPreferences.getString(Constants.PREFERENCES_USERID,null);
        mEditor = mSharedPreferences.edit();

    }

    @Override
    public void onClick(View view) {
        if(view == mAddStoreButton){
            String storeName = mShopNameEditText.getText().toString();
            String storeLocation = mLocationEditText.getText().toString();
            int userid = Integer.parseInt(userId);
            if (storeName.equals("") || storeLocation.equals("")) {
                Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_LONG).show();
                return ;
            }
            addStore(storeName,storeLocation,userid);

        }
    }

    public void addStore(String name , String location,int user){
        ApiService apiService = ApiClient.getClient();
        showProgressBar();
        Call<AddStoreResponse> call = apiService.addStore(name,location,user);
        call.enqueue(new Callback<AddStoreResponse>() {
            @Override
            public void onResponse(Call<AddStoreResponse> call, Response<AddStoreResponse> response) {
                if(response.isSuccessful()) {
                    Intent intent = new Intent(AddStoreActivity.this, AddStoreAdminActivity.class);
                    addStoreResponse = response.body();
                    String storeName = addStoreResponse.getStore().getName();
                    String storeId = String.valueOf(addStoreResponse.getStore().getId());
                    addToSharedPreferences(storeName);
                    addToSharedPreferences1(storeId);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Added SuccessFul",Toast.LENGTH_LONG).show();
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Failed", Toast.LENGTH_LONG).show();
                    hideProgressBar();
                }
            }


            @Override
            public void onFailure(Call<AddStoreResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Check your internet",Toast.LENGTH_LONG).show();
                hideProgressBar();
            }
        });
    }

    private void addToSharedPreferences(String storeName){
        mEditor.putString(Constants.PREFERENCES_STORE_KEY,storeName).apply();
    }

    private void addToSharedPreferences1(String storeId){
        mEditor.putString(Constants.PREFERENCES_STOREID,storeId).apply();
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
    private void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);

    }
}