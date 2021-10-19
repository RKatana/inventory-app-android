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
import android.widget.TextView;
import android.widget.Toast;

import com.app.inventoryapp.Constants;
import com.app.inventoryapp.R;
import com.app.inventoryapp.models.RegisterUserResponse;
import com.app.inventoryapp.network.ApiClient;
import com.app.inventoryapp.network.ApiService;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterStoreOwnerActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.createStoreOwner) Button mCreateStoreOwner;
    @BindView(R.id.nameEditText) EditText mNameEditText;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;
    @BindView(R.id.loginTextView) TextView mLoginTextView;
    @BindView(R.id.ProgressBar) ProgressBar mProgressBar;

    private RegisterUserResponse registerUserResponse;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_store_owner);

        ButterKnife.bind(this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

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
            String name = mNameEditText.getText().toString();
            String email = mEmailEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();
            String confirmPassword = mConfirmPasswordEditText.getText().toString();

            if (name.equals("") || email.equals("") || password.equals("") || confirmPassword.equals("")) {
                Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_LONG).show();

                return ;
            }else if(!password.equals(confirmPassword)) {
                Toast.makeText(getApplicationContext(),"Password not matched",Toast.LENGTH_LONG).show();

                return;
            }

            registerMerchant(name, email, password);

        }

    }

    public void registerMerchant(String name , String email , String password){
       ApiService apiService = ApiClient.getClient();
        showProgressBar();
       Call<RegisterUserResponse> call = apiService.registerUser(name, email, password);
       call.enqueue(new Callback<RegisterUserResponse>() {
           @Override
           public void onResponse(Call<RegisterUserResponse> call, Response<RegisterUserResponse> response) {
               if(response.isSuccessful()) {
                   Intent intent = new Intent(RegisterStoreOwnerActivity.this, AddStoreActivity.class);
                   startActivity(intent);
                   registerUserResponse = response.body();
                   String registeredUserName = registerUserResponse.getUser().getName();
                   addToSharedPreferences(registeredUserName);
                   Log.d("ownerRegister", registerUserResponse.getMessage());
                   Toast.makeText(getApplicationContext(), registerUserResponse.getMessage(), Toast.LENGTH_LONG).show();
                   finish();
               }
               else {
                   Toast.makeText(getApplicationContext(),"email already exist", Toast.LENGTH_LONG).show();
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

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
    private void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);

    }

}