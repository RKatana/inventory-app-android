package com.app.inventoryapp.network;


import com.app.inventoryapp.models.AddProductResponse;
import com.app.inventoryapp.models.AddStoreResponse;
import com.app.inventoryapp.models.GetProductsResponse;
import com.app.inventoryapp.models.GetStoresResponse;
import com.app.inventoryapp.models.GetUsersResponse;
import com.app.inventoryapp.models.LoginResponse;
import com.app.inventoryapp.models.RegisterUserResponse;
import com.app.inventoryapp.models.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @FormUrlEncoded
    @POST("authentication/auth/register/")
    Call<RegisterUserResponse> registerUser(
        @Field("name") String name,
        @Field("email") String email,
        @Field("password") String password
    );

    @FormUrlEncoded
    @POST("store/createstore/")
    Call<AddStoreResponse> addStore(
        @Field("name") String name,
        @Field("location") String location,
        @Field("user") int user
    );

    @GET("store/stores/")
    Call<GetStoresResponse> getStores(
            @Query("user") int user
    );
    @GET("authentication/auth/users/")
    Call<GetUsersResponse> getUsers(
            @Query("role")String role
    );

    @GET("product/products/")
    Call<GetProductsResponse> getProducts(
            @Query("store")int store
    );

    @FormUrlEncoded
    @POST("authentication/auth/login/")
    Call<LoginResponse> loginUser(
        @Field("email") String email,
        @Field("password") String password
    );

    @FormUrlEncoded
    @POST("product/createproduct/")
    Call<AddProductResponse> addProduct(
            @Field("name") String name,
            @Field("quantity") int quantity,
            @Field("buying_price") int buying_price,
            @Field("selling_price")int selling_price,
            @Field("spoilt") int spoilt,
            @Field("payment_status") Boolean payment_status,
            @Field("date") String date,
            @Field("store") int store
    );
    
}
