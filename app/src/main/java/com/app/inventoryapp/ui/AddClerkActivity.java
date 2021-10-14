package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.inventoryapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddClerkActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.passwordLoginButton) Button mPasswordLoginButton;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;

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
            Intent intent = new Intent(AddClerkActivity.this, MyClerksDashBoardActivity.class);
            startActivity(intent);
        }

    }
}