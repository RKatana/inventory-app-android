package com.app.inventoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.inventoryapp.R;
import com.app.inventoryapp.adapter.AttendantsListAdapter;
import com.app.inventoryapp.adapter.ProductsListAdapter;
import com.app.inventoryapp.models.Attendant;
import com.app.inventoryapp.models.GetUsersResponse;
import com.app.inventoryapp.network.ApiClient;
import com.app.inventoryapp.network.ApiService;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAdminsDashBoardActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.addAdminButton) Button mAddAdminButton;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.ProgressBar) ProgressBar mProgressBar;

    private AttendantsListAdapter mAdapter;
    private GetUsersResponse getUsersResponse;
    public List<Attendant> attendants;
    private String role;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_admins_dash_board);
        ButterKnife.bind(this);

        role = "STOREADMIN";

        fetchUsers(role);


        mAddAdminButton = (Button) findViewById(R.id.addAdminButton);
        mAddAdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == mAddAdminButton){
                    Intent intent = new Intent(MyAdminsDashBoardActivity.this, AddStoreAdminActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
    private void fetchUsers(String role){
        showProgressBar();
        ApiService apiService = ApiClient.getClient();
        Call<GetUsersResponse> call =apiService.getUsers(role);
        call.enqueue(new Callback<GetUsersResponse>() {
            @Override
            public void onResponse(Call<GetUsersResponse> call, Response<GetUsersResponse> response) {
                hideProgressBar();
                if(response.isSuccessful()){
                    getUsersResponse = response.body();
                    attendants = getUsersResponse.getUsers();
                    mAdapter = new AttendantsListAdapter(attendants,MyAdminsDashBoardActivity.this);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MyAdminsDashBoardActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    mRecyclerView.setVisibility(View.VISIBLE);
                }else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<GetUsersResponse> call, Throwable t) {
                showFailureMessage();
                hideProgressBar();
            }
        });
    }
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
    private void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);

    }
}