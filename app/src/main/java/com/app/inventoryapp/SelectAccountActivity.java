package com.app.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectAccountActivity extends AppCompatActivity {
    @BindView(R.id.btnStoreAttendant) Button btnStoreAttendant;
    @BindView(R.id.btnStoreOwner) Button btnStoreOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_account);

        ButterKnife.bind(this);

        
    }
}