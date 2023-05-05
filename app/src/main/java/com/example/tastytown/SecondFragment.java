package com.example.tastytown;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Objects;
import com.example.tastytown.API.ApiServices;


import androidx.fragment.app.Fragment;
import com.example.tastytown.Adaptor.GridFoodAdaptor;
import com.example.tastytown.Model.Food;
import com.google.gson.Gson;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondFragment extends Fragment {
//    RecyclerView.Adapter adapter;
    GridView _gridView;
    GridFoodAdaptor gridFoodAdaptor;
    ArrayList<Food> listFood = new ArrayList<>();
    ArrayList<Food> resData;
    boolean isCalled = false;

    public SecondFragment(){
        // require a empty public constructor
    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        getListFood(rootView);

        return rootView;
    }

      public void getListFood (View view) {
          ApiServices.apiService.getAllFood().enqueue(new Callback<ArrayList<Food>>() {
              @Override
              public void onResponse(Call<ArrayList<Food>> call, Response<ArrayList<Food>> response) {
                  Gson gson = new Gson();
                  resData = response.body();
                  int length = resData.size();
                  if(isCalled == false) {

                      for(int i=0; i<length; i++) {
                          listFood.add(resData.get(i));
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
    public void renderView(View rootView) {
        _gridView = rootView.findViewById(R.id.tasty_grid);
        gridFoodAdaptor = new GridFoodAdaptor(getActivity(), R.layout.food_item_tastys, listFood );
        _gridView.setAdapter(gridFoodAdaptor);
    }
}