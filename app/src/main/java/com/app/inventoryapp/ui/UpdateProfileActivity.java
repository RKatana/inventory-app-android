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
import android.widget.TextView;
import android.widget.Toast;

import com.app.inventoryapp.Constants;
import com.app.inventoryapp.R;
import com.app.inventoryapp.models.RegisterUserResponse;
import com.app.inventoryapp.network.ApiClient;
import com.app.inventoryapp.network.ApiService;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = " UpdateProfileActivity ";
    @BindView(R.id.user1Name) TextView userNameView;
    @BindView(R.id.updateDetails) Button mUpdateDetails;
    @BindView(R.id.nameEditText) EditText mNameEditText;
    @BindView(R.id.emailEditText) EditText mEmailEditText;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mUserName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();
        mUserName = mSharedPreferences.getString(Constants.PREFERENCES_USERNAME,null);


        mUpdateDetails.setOnClickListener(this);
    }

    private void addToSharedPreferences(String registeredUser){
        mEditor.putString(Constants.PREFERENCES_USERNAME,registeredUser).apply();
    }

    @Override
    public void onClick(View view) {
        if (view == mUpdateDetails) {
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
        }

    }
}