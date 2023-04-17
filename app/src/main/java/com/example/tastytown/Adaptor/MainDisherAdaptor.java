package com.example.tastytown.Adaptor;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tastytown.Activity.DetailFoodActivity;
import com.example.tastytown.Model.Food;
import com.example.tastytown.R;

import java.util.List;

public class MainDisherAdaptor extends RecyclerView.Adapter<MainDisherAdaptor.ViewHolder> {
    private List<Food> listFood;

    public MainDisherAdaptor(List<Food> listMainDisher) {
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
//        int drawResourseId = holder.itemView.getContext().getResources().getIdentifier(listFood.get(position).getImage(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(listFood.get(position).getImage())
                .into(holder.imageV);
        holder.imageV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailFoodActivity.class);
                intent.putExtra("object", listFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
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
