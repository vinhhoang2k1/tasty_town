package com.example.tastytown.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tastytown.Adaptor.CartAdapter;
import com.example.tastytown.Adaptor.FavoriteAdaptor;
import com.example.tastytown.Model.Food;
import com.example.tastytown.R;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {
    RecyclerView listFavoriteView;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        renderFavorite();
    }

    private void renderFavorite() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listFavoriteView = findViewById(R.id.favorite_list_food);
        listFavoriteView.setLayoutManager(linearLayoutManager);
        ArrayList<Food> listFood = new ArrayList<>();
        listFood.add(new Food("Burger", 30, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        adapter = new FavoriteAdaptor(listFood);
        listFavoriteView.setAdapter(adapter);
    }
}