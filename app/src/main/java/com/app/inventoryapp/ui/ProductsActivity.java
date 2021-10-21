package com.app.inventoryapp.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.inventoryapp.R;
import com.app.inventoryapp.adapter.ProductsListAdapter;
import com.app.inventoryapp.models.Product;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsActivity extends AppCompatActivity {

    @BindView(R.id.addProduct) TextView mAddProduct;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    private ImageView editButton, deleteButton;

    private ProductsListAdapter mAdapter;

    Product product1 = new Product("Air max",100,1000,2000,1,"dd-MM-yyyy");
    Product product2 = new Product("Nike Golf",100,1000,2000,1,"dd-MM-yyyy");
    Product product3 = new Product("Nike Pro",100,1000,2000,1,"dd-MM-yyyy");
    Product product4 = new Product("Nike+",100,1000,2000,1,"dd-MM-yyyy");
    Product product5 = new Product("Air Jordan",100,1000,2000,1,"dd-MM-yyyy");
    Product product6 = new Product("Nike Blazers",100,1000,2000,1,"dd-MM-yyyy");
    Product product7 = new Product(" Air Force 1",100,1000,2000,1,"dd-MM-yyyy");
    Product product8 = new Product("Nike Dunk",100,1000,2000,1,"dd-MM-yyyy");

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


    public void deleteButton(View view) {
        int id = view.getId();
        if (id == R.id.deleteButton) {
            AlertDialog.Builder alert = new AlertDialog.Builder(ProductsActivity.this);
            alert.setTitle("Alert!!");
            alert.setMessage("Are you sure to delete this Product?");
            alert.setCancelable(true);

            alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();

                }
            });

            alert.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();

                }
            });

            alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alert.show();

        }
    }
}