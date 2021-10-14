package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.inventoryapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterStoreOwnerActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.createStoreOwner) Button mCreateStoreOwner;
    @BindView(R.id.nameEditText) EditText mNameEditText;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;
    @BindView(R.id.loginTextView) TextView mLoginTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_store_owner);

        ButterKnife.bind(this);

        mLoginTextView.setOnClickListener(this);
        mCreateStoreOwner.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mLoginTextView){
            Intent intent = new Intent(RegisterStoreOwnerActivity.this, OwnerLoginActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        if (view == mCreateStoreOwner){
            Intent intent = new Intent(RegisterStoreOwnerActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

}