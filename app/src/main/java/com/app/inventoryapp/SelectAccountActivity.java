package com.app.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectAccountActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.btnStoreAttendant) Button mBtnStoreAttendant;
    @BindView(R.id.btnStoreOwner) Button mBtnStoreOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_account);

        ButterKnife.bind(this);
        mBtnStoreAttendant.setOnClickListener(this);
        mBtnStoreOwner.setOnClickListener(this);

        
    }

    @Override
    public void onClick(View view) {
        if (view == mBtnStoreAttendant){
            Intent intent = new Intent(SelectAccountActivity.this, AttendantLoginActivity.class);
            startActivity(intent);
            finish();
        }
        if (view == mBtnStoreOwner){
            Intent intent = new Intent(SelectAccountActivity.this, OwnerLoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}