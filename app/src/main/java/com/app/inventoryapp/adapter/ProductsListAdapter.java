package com.app.inventoryapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.inventoryapp.R;
import com.app.inventoryapp.models.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ProductsViewHolder>{

    public List<Product> mProducts = new ArrayList<>();
    private Context mContext;

    public ProductsListAdapter(List<Product> mProducts, Context mContext) {
        this.mProducts = mProducts;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ProductsListAdapter.ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_list_item,parent,false);
        ProductsViewHolder viewHolder = new ProductsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsListAdapter.ProductsViewHolder holder, int position) {
        holder.bindProduct(mProducts.get(position));
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.ProductName) TextView mProductTextView;
        @BindView(R.id.paymentStatus) TextView mPaymentStatusTextView;

        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }
        public void bindProduct (Product product){
            mProductTextView.setText(product.getName());
           // mPaymentStatusTextView.setText(product.getQuantity());
        }
    }
}