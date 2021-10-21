package com.app.inventoryapp.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.inventoryapp.R;
import com.app.inventoryapp.models.Product;
import com.app.inventoryapp.ui.UpdateProduct;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ProductsViewHolder>{

    public List<Product> mProducts;
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

        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, UpdateProduct.class);
                mContext.startActivity(i);
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });

    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        LinearLayout gone;
        TextView ProductName, paymentStatus, dateText;
        ImageView editButton, deleteButton;

        @BindView(R.id.ProductName) TextView mProductTextView;
        @BindView(R.id.paymentStatus) TextView mPaymentStatusTextView;
        @BindView(R.id.textView7) TextView mDateTextView;
        @BindView(R.id.productQuantity) TextView mQuantityTextView;
        @BindView(R.id.productSpoilt) TextView mSpoiltTextView;
        @BindView(R.id.productBp) TextView mBpTextView;
        @BindView(R.id.productSp) TextView mSpTextView;

        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            cv = (CardView) itemView.findViewById(R.id.cv);
            gone = (LinearLayout) itemView.findViewById(R.id.gone);

            ProductName = (TextView) itemView.findViewById(R.id. ProductName);
            dateText = (TextView) itemView.findViewById(R.id.dateText);
            paymentStatus = (TextView) itemView.findViewById(R.id.paymentStatus);

            editButton = (ImageView) itemView.findViewById(R.id.editButton);
            deleteButton = (ImageView) itemView.findViewById(R.id.deleteButton);
        }
        public void bindProduct (Product product){
            mProductTextView.setText(product.getName());
           Boolean paymentStatus = product.getPaymentStatus();
            mDateTextView.setText(product.getDateReceived());
            String quantity = String.valueOf(product.getQuantity());
            mQuantityTextView.setText(quantity);
            String spoilt = String.valueOf(product.getSpoilt());
            mSpoiltTextView.setText(spoilt);
            String bp = String.valueOf(product.getBuyingPrice());
            mBpTextView.setText(bp);
            String sp = String.valueOf(product.getSellingPrice());
            Log.d("ProductsListAdapter",sp);
            mSpTextView.setText(sp);
            if (paymentStatus = true){
               String payment = "paid";
                mPaymentStatusTextView.setText(payment);
            }else {
                String payment = "not paid";
                mPaymentStatusTextView.setText(payment);
            }
        }
    }
}