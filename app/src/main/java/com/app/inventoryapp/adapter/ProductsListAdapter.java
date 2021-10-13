package com.app.inventoryapp.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
                AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                alert.setTitle("Alert!!");
                alert.setMessage("Are you sure to delete this product?");

                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });

                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
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
           // mPaymentStatusTextView.setText(product.getQuantity());
        }
    }
}