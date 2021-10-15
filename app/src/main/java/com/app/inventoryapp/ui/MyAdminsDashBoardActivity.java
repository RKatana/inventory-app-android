package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.inventoryapp.R;
import com.app.inventoryapp.adapter.AttendantsListAdapter;
import com.app.inventoryapp.adapter.ProductsListAdapter;
import com.app.inventoryapp.models.Attendant;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdminsDashBoardActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.addAdminButton) Button mAddAdminButton;

    private AttendantsListAdapter mAdapter;

    Attendant attendant1 = new Attendant("John Kimani","john@gmail.com","123456","admin");
    Attendant attendant2 = new Attendant("Kelvin Munene","kelvinmunene@gmail.com","123456","admin");
    Attendant attendant3 = new Attendant("Stephen Odhiambo","odhiambo@gmail.com","123456","admin");


    public List<Attendant> attendants = Arrays.asList(new Attendant[]{attendant1, attendant2, attendant3});

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_admins_dash_board);
        ButterKnife.bind(this);

        mAdapter = new AttendantsListAdapter(attendants,this);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MyAdminsDashBoardActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setVisibility(View.VISIBLE);


        mAddAdminButton = (Button) findViewById(R.id.addAdminButton);
        mAddAdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == mAddAdminButton){
                    Intent intent = new Intent(MyAdminsDashBoardActivity.this, AddStoreAdminActivity.class);
                    startActivity(intent);
                }
            }
        });



    }
}