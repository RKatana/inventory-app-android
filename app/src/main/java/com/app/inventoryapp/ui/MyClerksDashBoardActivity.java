package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.app.inventoryapp.R;
import com.app.inventoryapp.adapter.AttendantsListAdapter;
import com.app.inventoryapp.models.Attendant;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyClerksDashBoardActivity extends AppCompatActivity {


    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    private AttendantsListAdapter mAdapter;

    Attendant attendant1 = new Attendant("john@gmail.com","123456","admin");
    Attendant attendant2 = new Attendant("john@gmail.com","123456","admin");
    Attendant attendant3 = new Attendant("john@gmail.com","123456","admin");
    Attendant attendant4 = new Attendant("john@gmail.com","123456","admin");
    Attendant attendant5 = new Attendant("john@gmail.com","123456","admin");
    Attendant attendant6 = new Attendant("john@gmail.com","123456","admin");
    Attendant attendant7 = new Attendant("john@gmail.com","123456","admin");
    Attendant attendant8 = new Attendant("john@gmail.com","123456","admin");

    public List<Attendant> attendants = Arrays.asList(new Attendant[]{attendant1, attendant2, attendant3, attendant4, attendant5, attendant6, attendant7, attendant8});
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_clerks_dash_board);
        ButterKnife.bind(this);

        mAdapter = new AttendantsListAdapter(attendants,this);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MyClerksDashBoardActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setVisibility(View.VISIBLE);

    }
}