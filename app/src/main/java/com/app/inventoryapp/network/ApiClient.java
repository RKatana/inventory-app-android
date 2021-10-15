package com.app.inventoryapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static String BASE_URL ="https://jumpstock.herokuapp.com/authentication/auth/register/";
    private static Retrofit retrofit = null;
    public static ApiClient getClient(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ApiClient api = retrofit.create(ApiClient.class);

        return api;
    }







}
