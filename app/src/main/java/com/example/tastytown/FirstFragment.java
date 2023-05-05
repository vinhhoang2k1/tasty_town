package com.example.tastytown;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastytown.API.ApiServices;
import com.example.tastytown.Adaptor.MainDisherAdaptor;
import com.example.tastytown.Model.Food;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment {
    RecyclerView.Adapter adapter;

    ArrayList<Food> listMainDisher = new ArrayList<>();
    ArrayList<Food> listSaladFood= new ArrayList<>();
    ArrayList<Food> listFastFood = new ArrayList<>();
    ArrayList<Food> listFruit= new ArrayList<>();
    ArrayList<Food> resData = new ArrayList<>();

    boolean isCalled = false;


    public FirstFragment(){
    }

    private void getFoodList(View view) {
        ApiServices.apiService.getAllFood().enqueue(new Callback<ArrayList<Food>>() {
            @Override
            public void onResponse(Call<ArrayList<Food>> call, Response<ArrayList<Food>> response) {
                Gson gson = new Gson();
                resData = response.body();
                int length = resData.size();
                if(isCalled == false) {
                    for(int i=0; i<length; i++) {
                        if(Objects.equals(resData.get(i).getType(),"main_food")) {
                            listMainDisher.add(resData.get(i));
                        }
                        if(Objects.equals(resData.get(i).getType(),"fast_food")) {
                            listFastFood.add(resData.get(i));
                        }
                        if(Objects.equals(resData.get(i).getType(),"salad")) {
                            listSaladFood.add(resData.get(i));
                        }
                        if(Objects.equals(resData.get(i).getType(),"fruit")) {
                            listFruit.add(resData.get(i));
                        }
                    }
                }

                requireActivity().runOnUiThread(() -> {
                    isCalled = true;
                    renderView(view);
                });


            }

            @Override
            public void onFailure(Call<ArrayList<Food>> call, Throwable t) {

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        getFoodList(rootView); // get listMainDisher
        return rootView;
    }
    public void renderView(View rootView) {
        RecyclerView recyclerMainDisher = (RecyclerView) rootView.findViewById(R.id.main_disher_grid);
        recyclerMainDisher.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new MainDisherAdaptor(listMainDisher);
        recyclerMainDisher.setAdapter(adapter);
        recyclerMainDisher.setItemAnimator(new DefaultItemAnimator());

        RecyclerView recyclerFastFood = (RecyclerView) rootView.findViewById(R.id.fast_food_list);
        recyclerFastFood.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new MainDisherAdaptor(listFastFood);
        recyclerFastFood.setAdapter(adapter);
        recyclerFastFood.setItemAnimator(new DefaultItemAnimator());

        RecyclerView recyclerSaladFood = (RecyclerView) rootView.findViewById(R.id.salad_list);
        recyclerSaladFood.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new MainDisherAdaptor(listSaladFood);
        recyclerSaladFood.setAdapter(adapter);
        recyclerSaladFood.setItemAnimator(new DefaultItemAnimator());

        RecyclerView recyclerFruit = (RecyclerView) rootView.findViewById(R.id.fruit_list);
        recyclerFruit.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new MainDisherAdaptor(listFruit);
        recyclerFruit.setAdapter(adapter);
        recyclerFruit.setItemAnimator(new DefaultItemAnimator());
    }
}