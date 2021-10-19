package com.app.inventoryapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.app.inventoryapp.R;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.admin_logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.exit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(AdminActivity.this);
            builder.setMessage("Do You Want To Exit?");
            builder.setCancelable(true);

            builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();

                }
            });

            builder.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }
        return true;
    }

    public void adminButton(View view) {
        int id = view.getId();
        if (R.id.storeProducts == id) {
            Toast.makeText(this, "View products", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, ProductsActivity.class);
            startActivity(i);
        }else if (R.id.storeReports == id) {
            Toast.makeText(this, "view Reports", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, GraphReportActivity.class);
            startActivity(i);

        }else if (R.id.storeClerks == id) {
            Toast.makeText(this, "view Clerks", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, MyClerksDashBoardActivity.class);
            startActivity(i);
        }
    }
}