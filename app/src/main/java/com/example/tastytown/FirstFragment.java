package com.example.tastytown;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastytown.Adaptor.MainDisherAdaptor;
import com.example.tastytown.Model.Food;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    RecyclerView.Adapter adapter;
    public FirstFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        RecyclerView recyclerMainDisher = (RecyclerView) rootView.findViewById(R.id.main_disher_grid);
        recyclerMainDisher.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        ArrayList<Food> listMainDisher = new ArrayList<>();
        listMainDisher.add(new Food("Chicken Burger", 12, "Delicious and tasty cheese burger one of tasty town’s finest, it has a record sale of 2000 orders and a rating of 4.8 since it’s introduction. no dull yourself oh!!", "main_disher__img_1"));
        listMainDisher.add(new Food("Jollof Rice", 20, "Tasty well seasoned Nigerian jollof rice popularly referred to as the best jollof in the world. Order now and get served a hot nice meal.", "food_img_2"));
        adapter = new MainDisherAdaptor(listMainDisher);
        recyclerMainDisher.setAdapter(adapter);
        recyclerMainDisher.setItemAnimator(new DefaultItemAnimator());

        RecyclerView recyclerFastFood = (RecyclerView) rootView.findViewById(R.id.fast_food_list);
        recyclerFastFood.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        ArrayList<Food> listFastFood = new ArrayList<>();
        listFastFood.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        listFastFood.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        listFastFood.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        listFastFood.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        listFastFood.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        adapter = new MainDisherAdaptor(listFastFood);
        recyclerFastFood.setAdapter(adapter);
        recyclerFastFood.setItemAnimator(new DefaultItemAnimator());

        RecyclerView recyclerSaladFood = (RecyclerView) rootView.findViewById(R.id.salad_list);
        recyclerSaladFood.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        ArrayList<Food> listSaladFood= new ArrayList<>();
        listSaladFood.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        listSaladFood.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        listSaladFood.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        listSaladFood.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        listSaladFood.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        adapter = new MainDisherAdaptor(listSaladFood);
        recyclerSaladFood.setAdapter(adapter);
        recyclerSaladFood.setItemAnimator(new DefaultItemAnimator());

        RecyclerView recyclerFruit = (RecyclerView) rootView.findViewById(R.id.fruit_list);
        recyclerFruit.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        ArrayList<Food> listFruit= new ArrayList<>();
        listFruit.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        listFruit.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        listFruit.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        listFruit.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        listFruit.add(new Food("Burger", 30, "Delicous", "main_disher__img_1"));
        adapter = new MainDisherAdaptor(listFruit);
        recyclerFruit.setAdapter(adapter);
        recyclerFruit.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }
}