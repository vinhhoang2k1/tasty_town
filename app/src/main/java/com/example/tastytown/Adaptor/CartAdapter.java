package com.example.tastytown.Adaptor;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tastytown.Model.Food;
import com.example.tastytown.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private ArrayList<Food> listFoodCart;

    public CartAdapter(ArrayList<Food> listFoodCart) {
        this.listFoodCart = listFoodCart;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_view_item,parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        holder.foodNameV.setText(listFoodCart.get(position).getName());
        holder.priceV.setText(String.valueOf(listFoodCart.get(position).getPrice()));
        Log.d("sss",listFoodCart.get(position).getImage() );
        int drawResourseId = holder.itemView.getContext().getResources().getIdentifier(listFoodCart.get(position).getImage(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawResourseId)
                .into(holder.imageV);
    }

    @Override
    public int getItemCount() {
        return listFoodCart.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageV;
        TextView foodNameV, priceV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageV = itemView.findViewById(R.id.cart_food_item_thumbnail);
            foodNameV = itemView.findViewById(R.id.tvFoodName);
            priceV = itemView.findViewById(R.id.tvFoodPrice);
        }
    }
}