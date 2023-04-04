package com.example.tastytown;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastytown.Activity.OrderActivity;
import com.example.tastytown.Adaptor.CartAdapter;
import com.example.tastytown.Helper.ManagerCart;
import com.example.tastytown.Interface.ChangeNumberItemsListener;
import com.example.tastytown.Model.Food;

import java.util.ArrayList;

public class ThirdFragment extends Fragment {
    RecyclerView.Adapter adapter;
    ManagerCart managerCart;
    public ThirdFragment(){
        // require a empty public constructor
    }

        @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        managerCart = new ManagerCart( getActivity());
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);
        RecyclerView recyclerFavoriteFood = (RecyclerView) rootView.findViewById(R.id.listCart);
        Button btnConfirmOrder = (Button) rootView.findViewById(R.id.btnConfirmOrder);

        recyclerFavoriteFood.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new CartAdapter(managerCart.getListCard(), getActivity(), new ChangeNumberItemsListener() {
            @Override
            public void changed() {
            }
        });
        recyclerFavoriteFood.setAdapter(adapter);
        recyclerFavoriteFood.setItemAnimator(new DefaultItemAnimator());
        btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), OrderActivity.class);
                    startActivity(intent);
                }
            });
        return rootView;
    }
}