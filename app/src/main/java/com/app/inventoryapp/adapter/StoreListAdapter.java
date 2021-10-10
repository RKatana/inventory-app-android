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
import com.app.inventoryapp.ui.MainActivity;
import com.app.inventoryapp.ui.ProductsActivity;
import com.app.inventoryapp.ui.SelectAccountActivity;
import com.app.inventoryapp.ui.StoresDashboardActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.StoreViewHolder>  {

    private List<Store> mStores;
    private  Context mContext;

    public StoreListAdapter(List<Store> mStores, Context mContext) {
        this.mStores = mStores;
        this.mContext = mContext;
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
        holder.bindStore(mStores.get(position));
    }

    @Override
    public int getItemCount() {
        return mStores.size();
    }

    public  class StoreViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{
        @BindView(R.id.storeName) TextView mStoreName;
        @BindView(R.id.storeLocation) TextView mStoreLocation;

        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindStore (Store store){
            mStoreName.setText(store.getName());
            mStoreLocation.setText(store.getLocation());
        }

        @Override
        public void onClick(View view) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, ProductsActivity.class);
            intent.putExtra("position", itemPosition);
            mContext.startActivity(intent);
        }
    }
}
