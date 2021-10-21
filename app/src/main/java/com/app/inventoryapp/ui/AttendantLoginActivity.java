package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.inventoryapp.Constants;
import com.app.inventoryapp.R;
import com.app.inventoryapp.models.LoginResponse;
import com.app.inventoryapp.network.ApiClient;
import com.app.inventoryapp.network.ApiService;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttendantLoginActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.passwordLoginButton) Button mPasswordLoginButton;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.loadingTextView) TextView mRegisterTextView;
    @BindView(R.id.ProgressBar) ProgressBar mProgressBar;

    private LoginResponse loginResponse;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

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
            loginMerchant(email,password);

        }
    }
    public void loginMerchant(String email,String password){
        ApiService apiService = ApiClient.getClient();
        showProgressBar();
        Call<LoginResponse> call = apiService.loginUser(email, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(AttendantLoginActivity.this, AdminActivity.class);
                    startActivity(intent);
                    loginResponse = response.body();
                    String userName = loginResponse.getAuthenticatedUser().getName();
                    int userId = loginResponse.getAuthenticatedUser().getId();
                    String role = loginResponse.getAuthenticatedUser().getRole();
                    String userid = String.valueOf(userId);
                    Log.d("ownerLogin", String.valueOf(loginResponse.getAuthenticatedUser().getId()));
                    addToSharedPreferences(userName);
                    addToSharedPreferences1(userid);
                    Toast.makeText(getApplicationContext(),loginResponse.getMessage(),Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"wrong credentials", Toast.LENGTH_LONG).show();
                    hideProgressBar();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"check your internet",Toast.LENGTH_LONG).show();
                hideProgressBar();
            }
        });
    }
    private void addToSharedPreferences(String loggedInUser){
        mEditor.putString(Constants.PREFERENCES_USERNAME,loggedInUser).apply();
    }
    private void addToSharedPreferences1(String userId){
        mEditor.putString(Constants.PREFERENCES_USERID,userId).apply();
    }
    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
    private void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);

    }
}