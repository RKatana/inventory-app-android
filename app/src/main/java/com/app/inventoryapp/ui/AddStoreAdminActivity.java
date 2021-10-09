package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.inventoryapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddStoreAdminActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.AddAdminButton) Button mAddAdminButton;
    @BindView(R.id.usernameEditText) EditText mUsernameEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_store_admin);
        ButterKnife.bind(this);

        mAddAdminButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mAddAdminButton){
            Intent intent = new Intent(AddStoreAdminActivity.this, StoresDashboardActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}