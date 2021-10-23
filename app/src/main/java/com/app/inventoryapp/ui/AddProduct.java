package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.inventoryapp.Constants;
import com.app.inventoryapp.R;
import com.app.inventoryapp.models.AddProductResponse;
import com.app.inventoryapp.network.ApiClient;
import com.app.inventoryapp.network.ApiService;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProduct extends AppCompatActivity implements View.OnClickListener{

    private TextInputLayout productLayout,productQuantityLayout, productSpoiltLayout, productSpLayout, productBpLayout, paymentStatusLayout, dateLayout;
    private EditText ProductName, productQuantity,paymentStatus, productSp, productBp, productSpoilt,dateText;
    private int mYear, mMonth, mDay;
    private Boolean paymentStatus2;
    private SharedPreferences mSharedPreferences;
    private String storeId;
    private AddProductResponse addProductResponse;


    @BindView(R.id.btn_add) Button mAddProduct;
    @BindView(R.id.btn_clear) Button mClearFields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product2);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        storeId = mSharedPreferences.getString(Constants.PREFERENCES_STOREID,null);

        productLayout = (TextInputLayout) findViewById(R.id.productLayout);
        paymentStatusLayout = (TextInputLayout) findViewById(R.id.paymentStatusLayout);
        productQuantityLayout = (TextInputLayout) findViewById(R.id.productQuantityLayout);
        dateLayout = (TextInputLayout) findViewById(R.id.dateLayout);
        productSpoiltLayout = (TextInputLayout) findViewById(R.id.productSpoiltLayout);
        productSpLayout = (TextInputLayout) findViewById(R.id.productSpLayout);
        productBpLayout = (TextInputLayout) findViewById(R.id.productBpLayout);

        ProductName = (EditText) findViewById(R.id.ProductName);
        productQuantity = (EditText) findViewById(R.id.productQuantity);
        productSp = (EditText) findViewById(R.id.productSp);
        productBp = (EditText) findViewById(R.id.productBp);
        productSpoilt = (EditText) findViewById(R.id.productSpoilt);
        paymentStatus = (EditText) findViewById(R.id.paymentStatus);
        dateText = (EditText) findViewById(R.id.dateText);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        dateText.setText(format.format(c.getTime()));

        dateText.setInputType(InputType.TYPE_NULL);
        dateText.setFocusable(false);
        dateText.setOnClickListener(this);
        mAddProduct.setOnClickListener(this);
        mClearFields.setOnClickListener(this);

    }

    public void addProduct(String name,int quantity,int buyingPrice,int sellingPrice,int spoilt,Boolean paymentStatus,String date,int store) {
        ApiService apiService = ApiClient.getClient();
        Call<AddProductResponse> call = apiService.addProduct(name,quantity,buyingPrice,sellingPrice,spoilt,paymentStatus,date,store);
        call.enqueue(new Callback<AddProductResponse>() {
            @Override
            public void onResponse(Call<AddProductResponse> call, Response<AddProductResponse> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(AddProduct.this,ProductsActivity.class);
                    addProductResponse = response.body();
                    String message = addProductResponse.getMessage();
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AddProductResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"check your internet",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void clear(View v) {
        m_clear();
    }

    public void m_clear() {
        ProductName.setText("");
        productQuantity.setText("");
        productSp.setText("");
        productBp.setText("");
        productSpoilt.setText("");

    }



    @Override
    public void onClick(View v) {
        if(v == mAddProduct){
            

            String name = ProductName.getText().toString();

            String quantity = productQuantity.getText().toString();
            int quantity1 = Integer.parseInt(quantity);

            String paymentStatus1 = paymentStatus.getText().toString();
            if(paymentStatus1 == "paid"){
               paymentStatus2 = true;
            }else {
                paymentStatus2 = false;
            }

            String sellingPrice = productSp.getText().toString();
            int sellingPrice1 = Integer.parseInt(sellingPrice);

            String buyingPrice = productBp.getText().toString();
            int buyingPrice1  = Integer.parseInt(buyingPrice);

            String spoilt = productSpoilt.getText().toString();
            int spoilt1 = Integer.parseInt(spoilt);

            int store = Integer.parseInt(storeId);

            String date = dateText.getText().toString();

            if (name.equals("") || quantity.equals("") || buyingPrice.equals("") || sellingPrice.equals("") || spoilt.equals("")) {
                Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_LONG).show();
                return ;
            }

            addProduct(name,quantity1,buyingPrice1,sellingPrice1,spoilt1,paymentStatus2,date,store);

            return ;
        }

        if(v == mClearFields){
            m_clear();
            return ;
        }

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                dateText.setText(format.format(calendar.getTime()));

            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();


    }
}