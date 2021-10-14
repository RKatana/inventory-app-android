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

public class UpdateProduct extends AppCompatActivity implements View.OnClickListener{
    private TextInputLayout productLayout, paymentStatusLayout, dateLayout;
    private EditText ProductName, paymentStatus, dateText;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_product);

        setTitle("Update Product");

        productLayout = (TextInputLayout) findViewById(R.id.productLayout);
        paymentStatusLayout = (TextInputLayout) findViewById(R.id.paymentStatusLayout);
        dateLayout = (TextInputLayout) findViewById(R.id.dateLayout);

        ProductName = (EditText) findViewById(R.id.ProductName);
        paymentStatus = (EditText) findViewById(R.id.paymentStatus);
        dateText = (EditText) findViewById(R.id.dateText);

        dateText.setInputType(InputType.TYPE_NULL);
        dateText.setFocusable(false);
        dateText.setOnClickListener(this);
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