package com.example.tastytown;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastytown.Adaptor.CartAdapter;
import com.example.tastytown.Model.Food;

import java.util.ArrayList;

public class ThirdFragment extends Fragment {
    RecyclerView.Adapter adapter;

    public ThirdFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);
        RecyclerView recyclerFavoriteFood = (RecyclerView) rootView.findViewById(R.id.listCart);
        recyclerFavoriteFood.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        ArrayList<Food> listFood = new ArrayList<>();
        listFood.add(new Food("Burger", 30, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        listFood.add(new Food("Burger", 20, "Delicous", "food_img_2"));
        adapter = new CartAdapter(listFood);
        recyclerFavoriteFood.setAdapter(adapter);
        recyclerFavoriteFood.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }
}