package com.example.tastytown.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tastytown.Helper.ManagerCart;
import com.example.tastytown.R;

public class OrderActivity extends AppCompatActivity {
    TextView tvSubtotalPrice, tvDelivery, tvDiscountPrice, tvTotalPrice, btnOrder;
    ManagerCart managerCart;

    double tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        managerCart = new ManagerCart(this);
        initView();
        getFee();

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this, PaySuccessActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        tvSubtotalPrice = findViewById(R.id.tvSubtotalPrice);
        tvDelivery = findViewById(R.id.tvDelivery);
        tvDiscountPrice = findViewById(R.id.tvDiscountPrice);
        tvTotalPrice = findViewById(R.id.tvTotalprice);
        btnOrder = findViewById(R.id.btnOrderBackToHome);
    }

    private void getFee() {
//        managerCart.getTotalFee()
//        phi giao hang : 10$
//        Giam gia 10%
        double deliveryFee = 10;
        double discount = 0.1;
        tax = Math.round((managerCart.getTotalFee() * discount) *100) /100;
        double totalItem = Math.round(managerCart.getTotalFee() * 100) /100;
        double total = Math.round((managerCart.getTotalFee() - tax + deliveryFee) * 100) / 100;
        tvSubtotalPrice.setText(String.valueOf(totalItem));
        tvDelivery.setText(String.valueOf(deliveryFee));
        tvDiscountPrice.setText(String.valueOf(tax));
        tvTotalPrice.setText(String.valueOf(total));
    }
}