package com.app.inventoryapp.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.app.inventoryapp.ui.AttendantLoginActivity;
import com.app.inventoryapp.ui.SelectAccountActivity;
import com.app.inventoryapp.ui.StoresDashboardActivity;

import java.util.ArrayList;
import java.util.List;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.ViewHolder>  {
    private static final String TAG = "StoreListAdapter";
    private ArrayList<Store> stores = new ArrayList<>();
    private Context context;

    public StoreListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stores_list_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder , int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.storeName.setText(stores.get(position).getName());
        holder.storeLocation.setText(stores.get(position).getLocation());
        holder.storeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return stores.size();
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

    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
        notifyDataSetChanged();
    }
}
