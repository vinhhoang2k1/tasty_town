package com.example.tastytown;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastytown.Adaptor.NotifiAdapter;
import com.example.tastytown.Model.Notifi;

import java.util.ArrayList;


public class FiveFragment extends Fragment {
    RecyclerView.Adapter adapter;

    public FiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_five, container, false);
        RecyclerView recyclerFavoriteFood = (RecyclerView) rootView.findViewById(R.id.notifi_list);
        recyclerFavoriteFood.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        ArrayList<Notifi> notifiList = new ArrayList<>();
        notifiList.add(new Notifi("Anh Tuan", "2:00", "Your order is received!", "notifi_thumbnail"));
        notifiList.add(new Notifi("Anh Tuan 2", "2:00", "Your order is received!", "notifi_thumbnail"));
        notifiList.add(new Notifi("Anh Tuan 3", "2:00", "Your order is received!", "notifi_thumbnail"));
        notifiList.add(new Notifi("Anh Tuan 4", "2:00", "Your order is received!", "notifi_thumbnail"));
        notifiList.add(new Notifi("Anh Tuan 5", "2:00", "Your order is received!", "notifi_thumbnail"));

        adapter = new NotifiAdapter(notifiList);
        recyclerFavoriteFood.setAdapter(adapter);
        recyclerFavoriteFood.setItemAnimator(new DefaultItemAnimator());
        return rootView;
//        return inflater.inflate(R.layout.fragment_five, container, false);
    }
}