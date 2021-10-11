package com.app.inventoryapp.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.app.inventoryapp.models.Store;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Utils {

    private static final String TAG = "Utils";
    private static final String DATABASE_NAME = "fake_database";
;
    private static int ID = 0;

    public Utils() {
    }

    public static int getId(){
        ID++;
        return ID;
    }

    public void initDatabase (Context context) {
        Log.d(TAG, "InitDatabase: started");
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Store store = new Store("StoreOne","Karen Market");

        Gson gson = new Gson();
        gson.toJson(store);
        String jsonFile = gson.toJson(store);
        editor.putString("StoreOne", jsonFile);
        editor.apply();

        ArrayList<Store> allStores = new ArrayList<>();

        allStores.add(new Store("StoreOne","KarenView"));



    }
}
