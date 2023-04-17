package com.example.tastytown.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.tastytown.Helper.ManagerCart;
import com.example.tastytown.Helper.MangerFavorite;
import com.example.tastytown.Model.Food;
import com.example.tastytown.R;

public class DetailFoodActivity extends AppCompatActivity {
    ImageView imageFoodView, favoriteFoodBtn, minusFoodBtn, plusFoodBtn, backBtn;
    TextView nameFoodView, descriptionFoodView, currentOrderView, priceFoodView;
    Button addToCartBtn;

    int countOrder = 1;

    private Food foodobject;
    private ManagerCart managerCart;
    private MangerFavorite mangerFavorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);
        managerCart = new ManagerCart(this);
        mangerFavorite = new MangerFavorite(this);


        initView();
        getBundle();
        renderFavoriteView();
        favoriteFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mangerFavorite.toggleFavorite(foodobject);
                renderFavoriteView();
            }
        });

    }

    private void renderFavoriteView() {
        if(mangerFavorite.getIsExistFavorite(foodobject) == false){
            int drawableResourseid = this.getResources().getIdentifier(String.valueOf(R.drawable.heart_icon), "drawable", this.getPackageName());
             Glide.with(this)
                .load(drawableResourseid)
                .into(favoriteFoodBtn);
        } else {
        int drawableResourseid = this.getResources().getIdentifier(String.valueOf(R.drawable.heart_icon_primary_color), "drawable", this.getPackageName());
            Glide.with(this)
                .load(drawableResourseid)
                .into(favoriteFoodBtn);
        };

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
        addToCartBtn = findViewById(R.id.btnConfirmOrder);
        backBtn = findViewById(R.id.food_detail_back_btn);
    }

    private void getBundle() {
        foodobject = (Food) getIntent().getSerializableExtra("object");
        int drawableResourseid = this.getResources().getIdentifier(foodobject.getImage(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(foodobject.getImage())
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

//        add to cart
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodobject.setNumberInCard(countOrder);
                managerCart.insertFood(foodobject);
            }
        });
    }
}