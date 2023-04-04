package com.example.tastytown;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tastytown.Adaptor.FavoriteAdaptor;
import com.example.tastytown.Helper.ManagerCart;
import com.example.tastytown.Helper.MangerFavorite;
import com.example.tastytown.Model.Food;

import java.util.ArrayList;


public class FourFragment extends Fragment {
    RecyclerView.Adapter adapter;
    MangerFavorite mangerFavorite;
    public FourFragment(){
        // require a empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mangerFavorite = new MangerFavorite( getActivity());
        View rootView = inflater.inflate(R.layout.fragment_four, container, false);
        RecyclerView recyclerFavoriteFood = (RecyclerView) rootView.findViewById(R.id.favorite_list_food);
        recyclerFavoriteFood.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        Log.d("ReRender","rener");
        adapter = new FavoriteAdaptor(mangerFavorite.getListFavorite());
        recyclerFavoriteFood.setAdapter(adapter);
        recyclerFavoriteFood.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }
}