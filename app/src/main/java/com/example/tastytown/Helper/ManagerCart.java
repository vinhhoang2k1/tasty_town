package com.example.tastytown.Helper;

import com.example.tastytown.Interface.ChangeNumberItemsListener;
import com.example.tastytown.Model.Food;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import java.util.ArrayList;

public class ManagerCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagerCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood (Food item) {
        ArrayList<Food> listFood = getListCard();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listFood.size(); i++) {
            if(listFood.get(i).getName().equals(item.getName())) {
                existAlready = true;
                n = i;
                break;
            }
        }
        if(existAlready) {
            listFood.get(n).setNumberInCard(item.getNumberInCard());
        }else {
            listFood.add(item);
        }
        tinyDB.putListObject("CardList", listFood);
        Toast myToast =  Toast.makeText(context, "Added To Card", Toast.LENGTH_LONG);
        myToast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        myToast.show();
    }

    public ArrayList<Food> getListCard() {
        return tinyDB.getListObject("CardList");
    }

    public void plusNumberFood(ArrayList<Food> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listFood.get(position).setNumberInCard(listFood.get(position).getNumberInCard() + 1);
        changeNumberItemsListener.changed();
        tinyDB.putListObject("CardList", listFood);
    }

    public void minusNumberFood(ArrayList<Food> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if(listFood.get(position).getNumberInCard() == 1) {
            listFood.remove(position);
        }else {
            listFood.get(position).setNumberInCard(listFood.get(position).getNumberInCard() - 1);
        }
        tinyDB.putListObject("CardList", listFood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<Food> listFood = getListCard();
        double fee = 0;
        for(int i = 0; i<listFood.size(); i++) {
            fee = fee + (listFood.get(i).getPrice() * listFood.get(i).getNumberInCard());
        }
        return  fee;
    }

}
