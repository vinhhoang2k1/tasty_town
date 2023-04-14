package com.example.tastytown.API;

import com.example.tastytown.Model.Food;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiServices {
    Gson gson = new Gson();
    ApiServices apiService = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/posts")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServices.class);
    @GET("8fabdaa87a82e8718f430ad34ef52671ceb64e95/data.json")

    Call<Food> getAllFood();
}
