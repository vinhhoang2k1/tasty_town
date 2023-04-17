package com.example.tastytown.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.tastytown.FifFragment;
import com.example.tastytown.FirstFragment;
import com.example.tastytown.FourFragment;
import com.example.tastytown.R;
import com.example.tastytown.SecondFragment;
import com.example.tastytown.ThirdFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    ImageView headCurrentIcon, notificationBtn;
    TextView headCurrentName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationViewApp);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home_menu);
        headCurrentName = findViewById(R.id.main_head_current_name);
        headCurrentIcon = findViewById(R.id.main_head_current_icon);
        notificationBtn = findViewById(R.id.notification_btn);

        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NotifyActivity.class);
                startActivity(intent);
            }
        });
    }


    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();

    ThirdFragment thirdFragment = new ThirdFragment();

    FourFragment fourFragment = new FourFragment();

    FifFragment fifFragment = new FifFragment();
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_menu:
                if(headCurrentName instanceof TextView && headCurrentIcon instanceof ImageView) {
                    headCurrentName.setText("Home");
                    handleLoadHeadIcon("house_icon");
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, firstFragment).commit();
                return true;
            case R.id.favorite_menu:
                headCurrentName.setText("Tastys");
                handleLoadHeadIcon("list_food");
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, secondFragment).commit();
                return true;
            case R.id.cart_menu:
                headCurrentName.setText("Your Cart");
                handleLoadHeadIcon("cart_icon");
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, thirdFragment).commit();
                return true;
            case R.id.chat_menu:
                headCurrentName.setText("Your Favorite");
                handleLoadHeadIcon("heart_icon");
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fourFragment).commit();
                return true;
            case R.id.profile_menu:
                headCurrentName.setText("Your Profile");
                handleLoadHeadIcon("people_icon");
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fifFragment).commit();
                return true;
        }
        return false;
    }
    private void handleLoadHeadIcon(String srcIcon) {
        int drawableResourseid = this.getResources().getIdentifier(srcIcon, "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourseid)
                .into(headCurrentIcon);
    }



}