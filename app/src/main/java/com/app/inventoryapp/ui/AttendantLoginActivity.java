package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.inventoryapp.R;

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

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    @Override
    public void onClick(View view) {
        if(view == mPasswordLoginButton){
            String email = mEmailEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();

            if (email.equals("") || password.equals("")) {
                Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_LONG).show();

                return ;

            }
            Intent intent = new Intent(AttendantLoginActivity.this, ClerkActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Logged SuccessFul",Toast.LENGTH_LONG).show();
            finish();
        }
    }
}