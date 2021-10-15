package com.app.inventoryapp.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.app.inventoryapp.R;
import com.app.inventoryapp.network.ApiClient;
import com.google.gson.JsonObject;

import org.json.JSONObject;

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

            Intent intent = new Intent(RegisterStoreOwnerActivity.this, AddStoreActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Account created SuccessFul",Toast.LENGTH_LONG).show();
            finish();

        }

    }



//    public void registerMerchant(String name , String email , String password) throws Exception{
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String registerUrl = "https://jumpstock.herokuapp.com/authentication/auth/register/";
//        JSONObject postData = new JSONObject();
////        postData.put("Name", name);
//        postData.put("Email", email);
//        postData.put("Password", password);
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, registerUrl, postData, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                AlertDialog alertDialog = new AlertDialog.Builder(RegisterStoreOwnerActivity.this).create();
//                alertDialog.setTitle("Success");
//                alertDialog.setIcon(R.drawable.ic_baseline_check_24);
//                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Done", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int which) {
//                        Intent intent = new Intent(RegisterStoreOwnerActivity.this, AddStoreActivity.class);
//                        startActivity(intent);
//                        finish();
//                    }
//                });
//                alertDialog.show();
//            }
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                AlertDialog alertDialog = new AlertDialog.Builder(RegisterStoreOwnerActivity.this).create();
//                alertDialog.setTitle("Failure");
//                alertDialog.setIcon(R.drawable.ic_baseline_warning_24);
//                alertDialog.setMessage("Email or userName Already taken");
//                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Okay", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int which) {
////
//                    }
//
//                });
//                alertDialog.show();
//            }
//        });
//
//        queue.add(jsonObjectRequest);
//
//    }

}