package com.example.tastytown.API;

import com.example.tastytown.Model.Food;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiServices {
    Gson gson = new Gson();
    ApiServices apiService = new Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/vinhhoang2k1/tasty_town/main/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServices.class);
    @GET("data.json")
    Call<ArrayList<Food>> getAllFood();
}
