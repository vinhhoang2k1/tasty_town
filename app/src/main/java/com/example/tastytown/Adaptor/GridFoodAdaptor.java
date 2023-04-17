package com.example.tastytown.Adaptor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.example.tastytown.Activity.DetailFoodActivity;
import com.example.tastytown.Model.Food;
import com.example.tastytown.R;

import java.util.ArrayList;
import java.util.List;

public class GridFoodAdaptor extends ArrayAdapter<Food> {
    Activity context;
    int resource;

    ArrayList<Food> objects;
    public GridFoodAdaptor(@NonNull Activity context, int resource, @NonNull ArrayList<Food> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        row = layoutInflater.inflate(this.resource, null);
        ConstraintLayout itemTasty;
        itemTasty = row.findViewById(R.id.item_tasty);
        TextView name = row.findViewById(R.id.tasty_item_name);
        TextView price = row.findViewById(R.id.tasty_item_price);
        ImageView image = row.findViewById(R.id.tasty_item_image);

        Food food = this.objects.get(position);
        name.setText(food.getName());
        price.setText(String.valueOf(food.getPrice()));
        Glide.with(row.getContext())
                .load(food.getImage())
                .into(image);

        itemTasty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DetailFoodActivity.class);
                intent.putExtra("object", food);
                getContext().startActivity(intent);
            }
        });
        return row;
    }
}
