package com.app.inventoryapp.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.inventoryapp.Constants;
import com.app.inventoryapp.R;
import com.app.inventoryapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private FrameLayout frameLayout;
    public static int flag = 0;

    private TextView storeProducts;
    private String mStoreName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);


        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initViews();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_view_tag, new StoreDetailsFragment());
        transaction.commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (flag == 0) {
            // super.onBackPressed();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to exit?").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });
            builder.show();
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container_view_tag, new StoreDetailsFragment()).commit();
        }
    }

    private void initViews() {
        Log.d(TAG,"initViews: selected");
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container_view_tag, new StoreDetailsFragment()).commit();


        } else if (id == R.id.ProductList) {
            Intent i = new Intent(this, ProductsActivity.class);
            startActivity(i);

        }else if (id == R.id.AddStore) {
            Intent i = new Intent(this, AddStoreActivity.class);
            startActivity(i);

        }else if (id == R.id.logout) {
            Toast.makeText(this, "LogOut: Selected", Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    public void storeButton(View view) {
        int id = view.getId();
        if (R.id.admins == id) {
            Intent i = new Intent(this, MyAdminsDashBoardActivity.class);
            startActivity(i);
        }else if (R.id.products == id) {
            Intent i = new Intent(this, ProductsActivity.class);
            startActivity(i);

        }else if (R.id.stores == id) {
            Toast.makeText(this, "Stores", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, StoresDashboardActivity.class);
            startActivity(i);

        }else if (R.id.reports == id) {
            Toast.makeText(this, "Reports", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, GraphReportActivity.class);
            startActivity(i);
        }else if (R.id.addStore == id) {
            Toast.makeText(this, "Add a store", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, AddStoreActivity.class);
            startActivity(i);
        }
    }


}