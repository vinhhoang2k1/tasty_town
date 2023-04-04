package com.example.tastytown.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tastytown.Model.Notifi;
import com.example.tastytown.R;

import java.util.ArrayList;

public class NotifiAdapter extends RecyclerView.Adapter<NotifiAdapter.ViewHolder> {

    private ArrayList<Notifi> listNotifi;

    public NotifiAdapter(ArrayList<Notifi> listFoodCart) {
        this.listNotifi = listNotifi;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_viewholder,parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull NotifiAdapter.ViewHolder holder, int position) {
        holder.shopNameV.setText(listNotifi.get(position).getShopName());
        holder.messageV.setText(listNotifi.get(position).getMessage());
        holder.timeV.setText(listNotifi.get(position).getTime());
        int drawResourseId = holder.itemView.getContext().getResources().getIdentifier(listNotifi.get(position).getImage(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawResourseId)
                .into(holder.imageV);
    }

    @Override
    public int getItemCount() {
        return listNotifi.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView shopNameV, timeV, messageV;
        ImageView imageV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shopNameV = itemView.findViewById(R.id.notifi_shopname);
            timeV = itemView.findViewById(R.id.notifi_time);
            messageV = itemView.findViewById(R.id.notifi_message);
            imageV = itemView.findViewById(R.id.notifi_thumbnail);
        }
    }
}
