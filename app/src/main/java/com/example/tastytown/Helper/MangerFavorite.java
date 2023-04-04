package com.example.tastytown.Helper;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.example.tastytown.Model.Food;

import java.util.ArrayList;

public class MangerFavorite {
    private Context context;
    private TinyDB tinyDB;

    public MangerFavorite(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context) ;
    }
    public boolean getIsExistFavorite(Food item) {
        ArrayList<Food> listFood = getListFavorite();
        boolean isExist = false;
        for (int i = 0; i < listFood.size(); i++) {
            if(listFood.get(i).getName().equals(item.getName())) {
                isExist = true;
            }else {
                isExist = false;
            }
        }
        return isExist;
    }

    public void toggleFavorite(Food item) {
        Log.d("run", item.getName());
        ArrayList<Food> listFood = getListFavorite();
        boolean existAlready = false;
        int position = 0;
        for (int i = 0; i < listFood.size(); i++) {
            if(listFood.get(i).getName().equals(item.getName())) {
                existAlready = true;
                position = i;
                break;
            }
        }
        if(existAlready) {
            removeFavorite(position);
        } else  {
            addFavorite(item);
        }

    }


    public void addFavorite (Food item) {
        ArrayList<Food> listFood = getListFavorite();
        listFood.add(item);
        tinyDB.putListObject("FavoriteList", listFood);
        Toast myToast =  Toast.makeText(context, "Added To favorite", Toast.LENGTH_LONG);
        myToast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        myToast.show();
    }
    public void removeFavorite(int position) {
        ArrayList<Food> listFood = getListFavorite();
        listFood.remove(position);
        tinyDB.putListObject("FavoriteList", listFood);
        Toast myToast =  Toast.makeText(context, "Remove from favorite", Toast.LENGTH_LONG);
        myToast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        myToast.show();
    }

    public ArrayList<Food> getListFavorite() {
        return tinyDB.getListObject("FavoriteList");
    }
}
