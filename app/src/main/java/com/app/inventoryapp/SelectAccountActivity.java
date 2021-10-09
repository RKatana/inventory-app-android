package com.app.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectAccountActivity extends AppCompatActivity {
    public static final String TAG = SelectAccountActivity.class.getSimpleName();
    private Button mBtnStoreAttendant;
    private Button mBtnStoreOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_account);

        mBtnStoreAttendant = (Button) findViewById(R.id.btnStoreAttendant);
        mBtnStoreAttendant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == mBtnStoreAttendant){
                    Intent intent = new Intent(SelectAccountActivity.this, AttendantLoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        mBtnStoreOwner = (Button) findViewById(R.id.btnStoreOwner);
        mBtnStoreOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == mBtnStoreOwner){
                    Intent intent = new Intent(SelectAccountActivity.this, OwnerLoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}