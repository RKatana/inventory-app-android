package com.app.inventoryapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.app.inventoryapp.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UpdateProduct extends AppCompatActivity implements View.OnClickListener{
    private TextInputLayout productLayout, paymentStatusLayout, dateLayout, productSpoiltLayout, productSpLayout, productBpLayout;
    private EditText ProductName, paymentStatus, dateText, productSpoilt, productSp, productBp;
    private int mYear, mMonth, mDay;

    private Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_product);


        setTitle("Update Product");

        productLayout = (TextInputLayout) findViewById(R.id.productLayout);
        paymentStatusLayout = (TextInputLayout) findViewById(R.id.paymentStatusLayout);
        dateLayout = (TextInputLayout) findViewById(R.id.dateLayout);
        productSpoiltLayout = (TextInputLayout) findViewById(R.id.productSpoiltLayout);
        productSpLayout = (TextInputLayout) findViewById(R.id.productSpLayout);
        productBpLayout = (TextInputLayout) findViewById(R.id.productBpLayout);

        ProductName = (EditText) findViewById(R.id.ProductName);
        paymentStatus = (EditText) findViewById(R.id.paymentStatus);
        dateText = (EditText) findViewById(R.id.dateText);
        productSpoilt = (EditText) findViewById(R.id.productSpoilt);
        productSp = (EditText) findViewById(R.id.productSp);
        productBp = (EditText) findViewById(R.id.productBp);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.delete_product,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.deleteButton) {
            AlertDialog.Builder alert = new AlertDialog.Builder(UpdateProduct.this);
            alert.setTitle("Alert!!");
            alert.setMessage("Are you sure to delete this Product?");
            alert.setCancelable(true);

            alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();

                }
            });

            alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            alert.show();

        }
        return true;
    }

    public void updateProduct(View view) {
        int id = view.getId();
        if (R.id.btn_update == id) {
            Toast.makeText(this, "Product Updated Successfully", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, ProductsActivity.class);
            startActivity(i);
        }
    }

    public void clear(View view) {
        btn_clear();
    }

    public void btn_clear() {
        ProductName.setText("");
        paymentStatus.setText("");
        productSpoilt.setText("");
        productSp.setText("");
        productBp.setText("");
        dateText.setText("");

    }
}