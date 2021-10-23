package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.inventoryapp.Constants;
import com.app.inventoryapp.R;
import com.app.inventoryapp.models.RegisterUserResponse;
import com.app.inventoryapp.network.ApiClient;
import com.app.inventoryapp.network.ApiService;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddStoreAdminActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.AddAdminButton) Button mAddAdminButton;
    @BindView(R.id.usernameEditText) EditText mUsernameEditText;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.ProgressBar) ProgressBar mProgressBar;

    private RegisterUserResponse registerUserResponse;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_store_admin);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mAddAdminButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == mAddAdminButton){
            String name = mUsernameEditText.getText().toString();
            String email = mEmailEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();

            if (name.equals("") || email.equals("") || password.equals("")) {
                Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_LONG).show();

                return ;
            }

            registerAttendant(name, email, password);
        }
    }

    public void registerAttendant(String name , String email , String password){
        ApiService apiService = ApiClient.getClient();
        showProgressBar();
        Call<RegisterUserResponse> call = apiService.registerUser(name, email, password);
        call.enqueue(new Callback<RegisterUserResponse>() {
            @Override
            public void onResponse(Call<RegisterUserResponse> call, Response<RegisterUserResponse> response) {
                if(response.isSuccessful()) {
                    Intent intent = new Intent(AddStoreAdminActivity.this, StoresDashboardActivity.class);
                    startActivity(intent);
                    registerUserResponse = response.body();
                    String registeredUserName = registerUserResponse.getUser().getName();
                    int userId = registerUserResponse.getUser().getId();
                    String userid = String.valueOf(userId);
                    //addToSharedPreferences(registeredUserName);
                    //addToSharedPreferences1(userid);
                    Log.d("ownerRegister", String.valueOf(registerUserResponse.getUser().getId()));
                    Toast.makeText(getApplicationContext(), registerUserResponse.getMessage(), Toast.LENGTH_LONG).show();
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Failed", Toast.LENGTH_LONG).show();
                    hideProgressBar();
                }
            }


            @Override
            public void onFailure(Call<RegisterUserResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Check your internet",Toast.LENGTH_LONG).show();
                hideProgressBar();
            }
        });
    }

    private void addToSharedPreferences(String registeredUser){
        mEditor.putString(Constants.PREFERENCES_USERNAME,registeredUser).apply();
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