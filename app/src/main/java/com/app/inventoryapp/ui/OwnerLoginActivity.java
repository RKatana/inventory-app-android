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

public class OwnerLoginActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.passwordLoginButton) Button mPasswordLoginButton;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.registerTextView) TextView mRegisterTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);

        ButterKnife.bind(this);

        mRegisterTextView.setOnClickListener(this);
        mPasswordLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mRegisterTextView){
            Intent intent = new Intent(OwnerLoginActivity.this, RegisterStoreOwnerActivity.class);
            startActivity(intent);
        }

        if(view == mPasswordLoginButton){
            Intent intent = new Intent(OwnerLoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }
}