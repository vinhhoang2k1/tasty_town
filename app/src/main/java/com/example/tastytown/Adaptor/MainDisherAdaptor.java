package com.example.tastytown.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tastytown.Model.Food;
import com.example.tastytown.R;

import java.util.ArrayList;

public class MainDisherAdaptor extends RecyclerView.Adapter<MainDisherAdaptor.ViewHolder> {
    private ArrayList<Food> listFood;

    public MainDisherAdaptor(ArrayList<Food> listMainDisher) {
        this.listFood = listMainDisher;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_disher_viewholder,parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MainDisherAdaptor.ViewHolder holder, int position) {
        int drawResourseId = holder.itemView.getContext().getResources().getIdentifier(listFood.get(position).getImage(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawResourseId)
                .into(holder.imageV);
    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
       ImageView imageV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageV = itemView.findViewById(R.id.main_disher_img);
        }
    }
}
