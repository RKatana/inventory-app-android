package com.app.inventoryapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.inventoryapp.Constants;
import com.app.inventoryapp.R;
import com.app.inventoryapp.models.Store;
import com.app.inventoryapp.ui.MainActivity;
import com.app.inventoryapp.ui.ProductsActivity;
import com.app.inventoryapp.ui.StoreDetailsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.StoreViewHolder>  {

    private static final String TAG = "StoreListAdapter";
    private List<Store> mStores;
    private  Context mContext;

    LinearLayout gone;
    CardView cv;

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
        Log.d(TAG,"onBindViewHolder: called");
        holder.mStoreName.setText(mStores.get(position).getName());
        holder.mStoreLocation.setText(mStores.get(position).getLocation());

    }

    @Override
    public int getItemCount() {
        return mStores.size();
    }

    public  class StoreViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{

        @BindView(R.id.storeName) TextView mStoreName;
        @BindView(R.id.storeLocation) TextView mStoreLocation;

        private SharedPreferences mSharedPreferences;
        private SharedPreferences.Editor mEditor;


        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
            mEditor = mSharedPreferences.edit();

            cv = (CardView) itemView.findViewById(R.id.cv);

            mStoreName =(TextView) itemView.findViewById(R.id.storeName);
            mStoreLocation =(TextView) itemView.findViewById(R.id.storeLocation);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        private void addToSharedPreferences(String storeName){
            mEditor.putString(Constants.PREFERENCES_STORE_KEY,storeName).apply();
        }

        private void addToSharedPreferences1(String storeId){
            mEditor.putString(Constants.PREFERENCES_STOREID,storeId).apply();
        }


        @Override
        public void onClick(View view) {
            int itemPosition = getLayoutPosition();
            String storeName = mStores.get(itemPosition).getName();
            String storeId = String.valueOf(mStores.get(itemPosition).getId());
            Intent intent = new Intent(mContext, MainActivity.class);
            addToSharedPreferences(storeName);
            addToSharedPreferences1(storeId);
            intent.putExtra("position", itemPosition);
            mContext.startActivity(intent);
        }
    }

    public void setmStores(List<Store> mStores) {
        this.mStores = mStores;
    }

}
