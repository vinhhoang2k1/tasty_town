package com.example.tastytown.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastytown.Adaptor.CartAdapter;
import com.example.tastytown.Model.Food;
import com.example.tastytown.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    RecyclerView listViewCart;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        renderCart();

    }

    public void renderCart() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        listViewCart = findViewById(R.id.listCart);
        listViewCart.setLayoutManager(linearLayoutManager);
        ArrayList<Food> cartList = new ArrayList<>();
        cartList.add(new Food("Burger", 30, "Delicous", "food_img_2"));
        cartList.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listViewCart.setAdapter(adapter);
    }
}

