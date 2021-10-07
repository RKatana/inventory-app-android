package com.app.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        btnStoreAttendant = (Button) findViewById(R.id.btnStoreAttendant);
        btnStoreAttendant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectAccountActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnStoreOwner = (Button) findViewById(R.id.btnStoreOwner);
        btnStoreOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectAccountActivity.this,RegisterStoreOwnerActivity.class);
                startActivity(intent);
            }
        });
    }
}