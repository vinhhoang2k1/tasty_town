package com.example.tastytown.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tastytown.R;

public class LaunchActivity extends AppCompatActivity {
    ConstraintLayout getStartedBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        getStartedBtn = findViewById(R.id.lauch_btn_start);

        getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LaunchActivity.this, StartedActivity.class);
                startActivity(intent);
            }
        });
    }
}