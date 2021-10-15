package com.app.inventoryapp.ui;

import static androidx.constraintlayout.motion.widget.TransitionBuilder.validate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
            String email = mEmailEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();

            if (email.equals("") || password.equals("")) {
                Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_LONG).show();

                return ;

            }

            Intent intent = new Intent(OwnerLoginActivity.this, StoresDashboardActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Logged SuccessFul",Toast.LENGTH_LONG).show();
            finish();
        }

    }

    private void validate(String email, String password) {
    }
}