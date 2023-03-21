package com.example.tastytown.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tastytown.R;

public class StartedActivity extends AppCompatActivity {
    TextView signInBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started);
        signInBtn = findViewById(R.id.start_sign_in_btn);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartedActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}