package com.example.mvvmpractice.rest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIs {

    @FormUrlEncoded
    @POST("/---/---/---/")
    Call<String> login(@Field("username") String username,
                       @Field("password") String password);
}
