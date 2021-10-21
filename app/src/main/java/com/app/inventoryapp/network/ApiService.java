package com.app.inventoryapp.network;


import com.app.inventoryapp.models.LoginResponse;
import com.app.inventoryapp.models.RegisterUserResponse;
import com.app.inventoryapp.models.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
    @POST("authentication/auth/login/")
    Call<LoginResponse> loginUser(
        @Field("email") String email,
        @Field("password") String password
    );


}
