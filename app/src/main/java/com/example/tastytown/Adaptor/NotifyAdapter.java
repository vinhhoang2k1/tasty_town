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
import com.example.tastytown.Model.Notify;
import com.example.tastytown.R;

import java.util.ArrayList;

public class NotifyAdapter extends RecyclerView.Adapter<NotifyAdapter.ViewHolder> {

    private ArrayList<Notify> listNotify;

    public NotifyAdapter(ArrayList<Notify> listNotify) {
        this.listNotify = listNotify;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_viewholder,parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull NotifyAdapter.ViewHolder holder, int position) {
        holder.shopNameV.setText(listNotify.get(position).getShopName());
        holder.messageV.setText(listNotify.get(position).getMessage());
        holder.timeV.setText(listNotify.get(position).getTime());
        Log.e("notifi apdapter", holder.imageV.toString());
        int drawResourseId = holder.itemView.getContext().getResources().getIdentifier(listNotify.get(position).getThumbnail(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawResourseId)
                .into(holder.imageV);
    }

    @Override
    public int getItemCount() {
        return listNotify.size();
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
