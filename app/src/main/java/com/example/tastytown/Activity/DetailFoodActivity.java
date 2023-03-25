package com.example.tastytown.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tastytown.Model.Food;
import com.example.tastytown.R;

public class DetailFoodActivity extends AppCompatActivity {
    ImageView imageFoodView, favoriteFoodBtn, minusFoodBtn, plusFoodBtn, backBtn;
    TextView nameFoodView, descriptionFoodView, currentOrderView, priceFoodView;
    Button addToCartBtn;

    int countOrder = 1;

    private Food foodobject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);
        initView();
        getBundle();

    }

    private void initView() {
        imageFoodView = findViewById(R.id.food_detail_image);
        favoriteFoodBtn = findViewById(R.id.food_detail_favorite_btn);
        minusFoodBtn = findViewById(R.id.food_detail_minus_btn);
        plusFoodBtn = findViewById(R.id.food_detail_plus_btn);
        nameFoodView = findViewById(R.id.food_detail_name);
        descriptionFoodView = findViewById(R.id.food_detail_description);
        currentOrderView = findViewById(R.id.food_detail_current_order);
        priceFoodView = findViewById(R.id.food_detail_price);
        addToCartBtn = findViewById(R.id.btnConfirm);
        backBtn = findViewById(R.id.food_detail_back_btn);
    }

    private void getBundle() {
        foodobject = (Food) getIntent().getSerializableExtra("object");
        int drawableResourseid = this.getResources().getIdentifier(foodobject.getImage(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourseid)
                .into(imageFoodView);
        nameFoodView.setText(foodobject.getName());
        descriptionFoodView.setText(foodobject.getDescription());
        priceFoodView.setText(String.valueOf(foodobject.getPrice()));
        currentOrderView.setText(String.valueOf(countOrder));

        minusFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(countOrder > 1) {
                    countOrder--;
                    currentOrderView.setText(String.valueOf(countOrder));
                }
            }
        });

        plusFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countOrder++;
                currentOrderView.setText(String.valueOf(countOrder));
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailFoodActivity.this.finish();
            }
        });
    }
}