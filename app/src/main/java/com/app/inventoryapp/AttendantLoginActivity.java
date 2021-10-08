package com.app.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttendantLoginActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.passwordLoginButton) Button mPasswordLoginButton;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.ProgressBar) ProgressBar mSignInProgressBar;
    @BindView(R.id.loadingTextView) TextView mLoadingSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendant_login);
        ButterKnife.bind(this);

        mPasswordLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mPasswordLoginButton){
            Intent intent = new Intent(AttendantLoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
}