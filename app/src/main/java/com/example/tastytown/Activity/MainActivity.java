package com.example.tastytown.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.tastytown.FifFragment;
import com.example.tastytown.FirstFragment;
import com.example.tastytown.FourFragment;
import com.example.tastytown.R;
import com.example.tastytown.SecondFragment;
import com.example.tastytown.ThirdFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationViewApp);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home_menu);
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
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, firstFragment).commit();
                return true;
            case R.id.favorite_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, secondFragment).commit();
                return true;
            case R.id.cart_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, thirdFragment).commit();
                return true;
            case R.id.chat_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fourFragment).commit();
                return true;
            case R.id.profile_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fifFragment).commit();
                return true;
        }
        return false;
    }
}