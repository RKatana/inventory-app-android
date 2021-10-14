package com.app.inventoryapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.inventoryapp.R;
import com.app.inventoryapp.models.Attendant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttendantsListAdapter extends RecyclerView.Adapter<AttendantsListAdapter.AttendantsViewHolder>{

    public List<Attendant> mAttendants;
    private Context mContext;

    public AttendantsListAdapter(List<Attendant> mAttendants, Context mContext) {
        this.mAttendants = mAttendants;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AttendantsListAdapter.AttendantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendants_list_item,parent,false);
        AttendantsViewHolder viewHolder = new AttendantsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AttendantsListAdapter.AttendantsViewHolder holder, int position) {
        holder.bindProduct(mAttendants.get(position));
    }

    @Override
    public int getItemCount() {
        return mAttendants.size();
    }

    public class AttendantsViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.attendantName) TextView mAttendantTextView;
        @BindView(R.id.attendantEmail) TextView mAttendantEmailTextView;

        public AttendantsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }
        public void bindProduct (Attendant attendant){
            mAttendantTextView.setText(attendant.getName());
            mAttendantEmailTextView.setText(attendant.getEmail());
        }
    }
}
