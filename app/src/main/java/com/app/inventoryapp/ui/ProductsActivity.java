package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.inventoryapp.R;
import com.app.inventoryapp.adapter.ProductsListAdapter;
import com.app.inventoryapp.models.Product;
import com.app.inventoryapp.models.Store;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsActivity extends AppCompatActivity {

    @BindView(R.id.ProductTextView) TextView mProductTextView;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private ProductsListAdapter mAdapter;

    Product product1 = new Product("Air max",100,1000,2000,1);
    Product product2 = new Product("Nike Golf",100,1000,2000,1);
    Product product3 = new Product("Nike Pro",100,1000,2000,1);
    Product product4 = new Product("Nike+",100,1000,2000,1);
    Product product5 = new Product("Air Jordan",100,1000,2000,1);
    Product product6 = new Product("Nike Blazers",100,1000,2000,1);
    Product product7 = new Product(" Air Force 1",100,1000,2000,1);
    Product product8 = new Product("Nike Dunk",100,1000,2000,1);

    public List<Product> products = Arrays.asList(new Product[]{product1, product2, product3, product4, product5, product6, product7, product8});

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        ButterKnife.bind(this);

        mAdapter = new ProductsListAdapter(products,this);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ProductsActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setVisibility(View.VISIBLE);

    }
}