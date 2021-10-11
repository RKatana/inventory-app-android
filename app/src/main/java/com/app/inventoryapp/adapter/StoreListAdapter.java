package com.app.inventoryapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.inventoryapp.R;
import com.app.inventoryapp.models.Store;
import com.app.inventoryapp.ui.MainActivity;
import com.app.inventoryapp.ui.ProductsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.StoreViewHolder>  {

    private static final String TAG = "StoreListAdapter";
    private ArrayList<Store> stores;
    private  Context context;

    public StoreListAdapter(ArrayList<Store> stores, Context context) {
        this.stores = stores;
        this.context = context;
    }

    public StoreListAdapter() {
    }

    @NonNull
    @Override
    public StoreListAdapter.StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stores_list_item,parent,false);
        StoreViewHolder viewHolder = new StoreViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StoreListAdapter.StoreViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder: called");
        holder.storeName.setText(stores.get(position).getName());
        holder.storeLocation.setText(stores.get(position).getLocation());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigate to main store fragment
            }
        });


    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    public  class StoreViewHolder extends  RecyclerView.ViewHolder {
       private ImageView imageView;
       private TextView storeName;
       private TextView storeLocation;
       private CardView parent;

        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            storeName =(TextView) itemView.findViewById(R.id.storeName);
            storeLocation =(TextView) itemView.findViewById(R.id.storeLocation);
            parent = (CardView) itemView.findViewById(R.id.parent) ;
            context = itemView.getContext();

            itemView.setOnClickListener(this);
        }

    }

    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
        notifyDataSetChanged();
    }
}
