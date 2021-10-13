package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.app.inventoryapp.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddProduct extends AppCompatActivity implements View.OnClickListener{

    private TextInputLayout productLayout,productQuantityLayout, productSpoiltLayout, productSpLayout, productBpLayout, paymentStatusLayout, dateLayout;
    private EditText ProductName, productQuantity,paymentStatus, productSp, productBp, productSpoilt,dateText;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        productLayout = (TextInputLayout) findViewById(R.id.productLayout);
        paymentStatusLayout = (TextInputLayout) findViewById(R.id.paymentStatusLayout);
        dateLayout = (TextInputLayout) findViewById(R.id.dateLayout);

        ProductName = (EditText) findViewById(R.id.ProductName);
        paymentStatus = (EditText) findViewById(R.id.paymentStatus);
        dateText = (EditText) findViewById(R.id.dateText);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        dateText.setText(format.format(c.getTime()));

        dateText.setInputType(InputType.TYPE_NULL);
        dateText.setFocusable(false);
        dateText.setOnClickListener(this);
    }

    public void addInfo(View v) {
        String name = ProductName.getText().toString();
        String quantity = productQuantity.getText().toString();
        String sellingPrice = productSp.getText().toString();
        String buyingPrice = productBp.getText().toString();
        String spoilt = productSpoilt.getText().toString();
        String date = dateText.getText().toString();

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

    public boolean validate() {
        int flag = 0;
        if (ProductName.getText().toString().trim().isEmpty()) {
            flag = 1;
            productLayout.setError("Cannot be Empty");
        } else
            productLayout.setErrorEnabled(false);

        if (productQuantity.getText().toString().trim().isEmpty()) {
            flag = 1;
            productQuantityLayout.setError("Cannot be Empty");
        } else
            productQuantityLayout.setErrorEnabled(false);
        if (dateText.getText().toString().trim().isEmpty()) {
            flag = 1;
            dateLayout.setError("Cannot be Empty");
        } else
            dateLayout.setErrorEnabled(false);
        if (productSp.getText().toString().trim().isEmpty()) {
            flag = 1;
            productSpLayout.setError("Cannot be Empty");
        } else
            productSpLayout.setErrorEnabled(false);

        if (productBp.getText().toString().trim().isEmpty()) {
            flag = 1;
            productBpLayout.setError("Cannot be Empty");
        } else
            productBpLayout.setErrorEnabled(false);

        if (productSpoilt.getText().toString().trim().isEmpty()) {
            flag = 1;
            productSpoiltLayout.setError("Cannot be Empty");
        } else
            productSpoiltLayout.setErrorEnabled(false);

        if (flag == 1)
            return false;
        else
            return true;
    }

    @Override
    public void onClick(View v) {

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