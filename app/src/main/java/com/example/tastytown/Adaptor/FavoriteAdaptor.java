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

public class FavoriteAdaptor extends RecyclerView.Adapter<FavoriteAdaptor.ViewHolder> {
    private ArrayList<Food> listFoodFavorite;

    public FavoriteAdaptor(ArrayList<Food> listFoodCart) {
        this.listFoodFavorite = listFoodCart;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_viewholder,parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.foodNameV.setText(listFoodFavorite.get(position).getName());
        holder.priceV.setText(String.valueOf(listFoodFavorite.get(position).getPrice()));
        int drawResourseId = holder.itemView.getContext().getResources().getIdentifier(listFoodFavorite.get(position).getImage(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawResourseId)
                .into(holder.imageV);
    }

    @Override
    public int getItemCount() {
        return listFoodFavorite.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageV;
        TextView foodNameV, priceV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageV = itemView.findViewById(R.id.favorite_item_image);
            foodNameV = itemView.findViewById(R.id.favorite_item_name);
            priceV = itemView.findViewById(R.id.favorite_item_price);
        }
    }
}