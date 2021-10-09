package com.app.inventoryapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.inventoryapp.R;
import com.app.inventoryapp.models.Store;

import java.util.ArrayList;
import java.util.List;

//public class StoreListAdapter extends ArrayAdapter {
//    private Context mContext;
//    private Store[] mStores;
//
//    public StoreListAdapter(@NonNull Context context, int resource, Store[] mStores) {
//        super(context, resource);
//        this.mContext = mContext;
//        this.mStores = mStores;
//    }
//    @Override
//    public Object getItem(int position){
//        Store stores = mStores[position];
//        return stores;
//    }
//
//    @Override
//    public  int getCount(){
//        return mStores.length;
//    }
//}

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.ViewHolder>  {
    private static final String TAG = "StoreListAdapter";
    private Store[] stores;
    private Context context;

    public StoreListAdapter(Context context, Store[] stores) {
        this.context = context;
        this.stores = stores;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return stores.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView storeName;
        private TextView storeLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            storeName = (TextView) itemView.findViewById(R.id.storeName);
            storeLocation = (TextView) itemView.findViewById(R.id.storeLocation);
        }
    }
}
