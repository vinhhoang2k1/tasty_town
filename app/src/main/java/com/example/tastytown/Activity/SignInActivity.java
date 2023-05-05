package com.example.tastytown.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tastytown.R;

import java.util.Objects;

public class SignInActivity extends AppCompatActivity {
    TextView submitBtn;
    EditText sign_in_user_name,sign_in_password;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        submitBtn = findViewById(R.id.sign_in_submit_btn);
        sign_in_user_name = findViewById(R.id.sign_in_user_name);
        sign_in_password = findViewById(R.id.sign_in_password);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(handleCheckSignIn(sign_in_user_name.getText().toString(), sign_in_password.getText().toString())) {
                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    public boolean handleCheckSignIn (String username, String password) {
        if(username.length() == 0 || password.length() == 0) {
            showToast("You must enter username and password");
            return false;
        } else if(!Objects.equals(username, "user@gmail.com")) {
            showToast("Username is invalid ");
            return false;
        } else if (!Objects.equals(password, "password")) {
            showToast("Password is invalid ");
            return false;
        } else {
            return true;
        }

    }
    public void showToast(String mes) {
        Toast myToast =  Toast.makeText(this, mes, Toast.LENGTH_LONG);
        myToast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        myToast.show();
    }
}