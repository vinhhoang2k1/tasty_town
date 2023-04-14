package com.example.tastytown.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tastytown.R;

public class PaySuccessActivity extends AppCompatActivity {
    TextView btnBackToHome;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_success);
        btnBackToHome = findViewById(R.id.btnOrderBackToHome);
        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaySuccessActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}