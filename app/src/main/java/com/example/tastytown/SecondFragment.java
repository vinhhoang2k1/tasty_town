package com.example.tastytown;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.io.*;
import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastytown.Adaptor.FavoriteAdaptor;
import com.example.tastytown.Adaptor.GridFoodAdaptor;
import com.example.tastytown.Adaptor.MainDisherAdaptor;
import com.example.tastytown.Model.Food;

public class SecondFragment extends Fragment {
//    RecyclerView.Adapter adapter;
    GridView _gridView;
    GridFoodAdaptor gridFoodAdaptor;
    ArrayList<Food> listFood = new ArrayList<>();
    public SecondFragment(){
        // require a empty public constructor
    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        _gridView = rootView.findViewById(R.id.tasty_grid);
        listFood.add(new Food("Burger", 30, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));

        gridFoodAdaptor = new GridFoodAdaptor(getActivity(), R.layout.food_item_tastys, listFood );
        _gridView.setAdapter(gridFoodAdaptor);
        return rootView;
    }
}