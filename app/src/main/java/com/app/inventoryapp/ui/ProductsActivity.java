package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.inventoryapp.Constants;
import com.app.inventoryapp.R;
import com.app.inventoryapp.adapter.ProductsListAdapter;
import com.app.inventoryapp.models.GetProductsResponse;
import com.app.inventoryapp.models.Product;
import com.app.inventoryapp.models.Store;
import com.app.inventoryapp.network.ApiClient;
import com.app.inventoryapp.network.ApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {

    @BindView(R.id.addProduct) TextView mAddProduct;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.ProgressBar) ProgressBar mProgressBar;

    private ImageView editButton, deleteButton;
    private SharedPreferences mSharedPreferences;
    private ProductsListAdapter mAdapter;
    private GetProductsResponse getProductsResponse;
    public List<Product> products;
    private int storeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        storeId = Integer.parseInt(mSharedPreferences.getString(Constants.PREFERENCES_STOREID,null));

        ButterKnife.bind(this);

        fetchProducts(storeId);

        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
        }

        mAddProduct = (Button) findViewById(R.id.addProduct);
        mAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == mAddProduct){
                    Intent intent = new Intent(ProductsActivity.this, AddProduct.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void fetchProducts(int StoreId){
        showProgressBar();
        ApiService apiService = ApiClient.getClient();
        Call<GetProductsResponse> call = apiService.getProducts(storeId);
        call.enqueue(new Callback<GetProductsResponse>() {
            @Override
            public void onResponse(Call<GetProductsResponse> call, Response<GetProductsResponse> response) {
                if (response.isSuccessful()){
                    hideProgressBar();
                    getProductsResponse = response.body();
                    products = getProductsResponse.getProducts();
                    mAdapter = new ProductsListAdapter(products,ProductsActivity.this);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ProductsActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    mRecyclerView.setVisibility(View.VISIBLE);
                }else {
                    showUnsuccessfulMessage();
                    hideProgressBar();
                }
            }

            @Override
            public void onFailure(Call<GetProductsResponse> call, Throwable t) {
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