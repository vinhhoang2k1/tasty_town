package com.example.tastytown.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.GridView;

import com.example.tastytown.Adaptor.MainDisherAdaptor;
import com.example.tastytown.Model.Food;
import com.example.tastytown.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mainDishers, salads, fastFoods, fruits;
    RecyclerView.Adapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        renderMainDisher();
        renderFastFood();
        renderSalad();
        renderFruit();
    }

    private void renderMainDisher() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mainDishers = findViewById(R.id.main_disher_grid);
        mainDishers.setLayoutManager(linearLayoutManager);
        ArrayList<Food> listMainDisher = new ArrayList<>();
        listMainDisher.add(new Food("main_disher__img_1"));
        listMainDisher.add(new Food("main_disher__img_1"));
        listMainDisher.add(new Food("main_disher__img_1"));
        listMainDisher.add(new Food("main_disher__img_1"));
        listMainDisher.add(new Food("main_disher__img_1"));
        listMainDisher.add(new Food("main_disher__img_1"));
        listMainDisher.add(new Food("main_disher__img_1"));
        listMainDisher.add(new Food("main_disher__img_1"));
        listMainDisher.add(new Food("main_disher__img_1"));
        listMainDisher.add(new Food("main_disher__img_1"));
        adapter = new MainDisherAdaptor(listMainDisher);
        mainDishers.setAdapter(adapter);
    }
    private void renderFastFood() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        fastFoods = findViewById(R.id.fast_food_list);
        fastFoods.setLayoutManager(linearLayoutManager);
        ArrayList<Food> listFastFood = new ArrayList<>();
        listFastFood.add(new Food("main_disher__img_1"));
        listFastFood.add(new Food("main_disher__img_1"));
        listFastFood.add(new Food("main_disher__img_1"));
        listFastFood.add(new Food("main_disher__img_1"));
        listFastFood.add(new Food("main_disher__img_1"));
        listFastFood.add(new Food("main_disher__img_1"));
        listFastFood.add(new Food("main_disher__img_1"));
        listFastFood.add(new Food("main_disher__img_1"));
        listFastFood.add(new Food("main_disher__img_1"));
        listFastFood.add(new Food("main_disher__img_1"));
        adapter = new MainDisherAdaptor(listFastFood);
        fastFoods.setAdapter(adapter);
    }
    private void renderSalad() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        salads = findViewById(R.id.salad_list);
        salads.setLayoutManager(linearLayoutManager);
        ArrayList<Food> listSalad = new ArrayList<>();
        listSalad.add(new Food("main_disher__img_1"));
        listSalad.add(new Food("main_disher__img_1"));
        listSalad.add(new Food("main_disher__img_1"));
        listSalad.add(new Food("main_disher__img_1"));
        listSalad.add(new Food("main_disher__img_1"));
        listSalad.add(new Food("main_disher__img_1"));
        listSalad.add(new Food("main_disher__img_1"));
        listSalad.add(new Food("main_disher__img_1"));
        listSalad.add(new Food("main_disher__img_1"));
        listSalad.add(new Food("main_disher__img_1"));
        adapter = new MainDisherAdaptor(listSalad);
        salads.setAdapter(adapter);
    }
    private void renderFruit() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        fruits = findViewById(R.id.fruit_list);
        fruits.setLayoutManager(linearLayoutManager);
        ArrayList<Food> listFruit = new ArrayList<>();
        listFruit.add(new Food("main_disher__img_1"));
        listFruit.add(new Food("main_disher__img_1"));
        listFruit.add(new Food("main_disher__img_1"));
        listFruit.add(new Food("main_disher__img_1"));
        listFruit.add(new Food("main_disher__img_1"));
        listFruit.add(new Food("main_disher__img_1"));
        listFruit.add(new Food("main_disher__img_1"));
        listFruit.add(new Food("main_disher__img_1"));
        listFruit.add(new Food("main_disher__img_1"));
        listFruit.add(new Food("main_disher__img_1"));
        adapter = new MainDisherAdaptor(listFruit);
        fruits.setAdapter(adapter);
    }



}