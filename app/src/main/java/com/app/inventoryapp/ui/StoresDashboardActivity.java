package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.inventoryapp.Constants;
import com.app.inventoryapp.R;
import com.app.inventoryapp.adapter.ProductsListAdapter;
import com.app.inventoryapp.adapter.StoreListAdapter;
import com.app.inventoryapp.models.GetStoresResponse;
import com.app.inventoryapp.models.Store;
import com.app.inventoryapp.network.ApiClient;
import com.app.inventoryapp.network.ApiService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoresDashboardActivity extends AppCompatActivity {
    private static final String TAG = "StoresDashboardActivity";
    @BindView(R.id.storeRecyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.ProgressBar) ProgressBar mProgressBar;

    private SharedPreferences mSharedPreferences;
    private StoreListAdapter mAdapter;
    private GetStoresResponse getStoresResponse;
    public List<Store> Stores ;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores_dashboard);

        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        userId = mSharedPreferences.getString(Constants.PREFERENCES_USERID,null);
        int userid = Integer.parseInt(userId);
        Log.d("StoreDashbordActicity",userId);

        fetchStores(userId);
    }

    private void  fetchStores(String userId){
        showProgressBar();
        ApiService apiService = ApiClient.getClient();
        Call<GetStoresResponse> call = apiService.getStoreById(userId);
        call.enqueue(new Callback<GetStoresResponse>() {
            @Override
            public void onResponse(Call<GetStoresResponse> call, Response<GetStoresResponse> response) {
                hideProgressBar();
                if(response.isSuccessful()){
                    getStoresResponse = response.body();
                    Stores = getStoresResponse.getStores();
                    mAdapter = new StoreListAdapter(Stores,StoresDashboardActivity.this);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(StoresDashboardActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    mRecyclerView.setVisibility(View.VISIBLE);

                }else {
                    showUnsuccessfulMessage();
                }

            }

            @Override
            public void onFailure(Call<GetStoresResponse> call, Throwable t) {
                showFailureMessage();
                hideProgressBar();
            }
        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
    private void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);

    }
}