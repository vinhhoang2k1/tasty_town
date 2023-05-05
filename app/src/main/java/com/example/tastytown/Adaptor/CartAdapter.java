package com.example.tastytown.Adaptor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tastytown.Helper.ManagerCart;
import com.example.tastytown.Interface.ChangeNumberItemsListener;
import com.example.tastytown.Model.Food;
import com.example.tastytown.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private ArrayList<Food> listFoodCart;
    private ManagerCart managerCart;
    private ChangeNumberItemsListener changeNumberItemsListener;
    public CartAdapter(ArrayList<Food> listFoodCart, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listFoodCart = listFoodCart;
        this.managerCart = new ManagerCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
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
        holder.tvFoodQuantity.setText(String.valueOf(listFoodCart.get(position).getNumberInCard()));
//        int drawResourseId = holder.itemView.getContext().getResources().getIdentifier(listFoodCart.get(position).getImage(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(listFoodCart.get(position).getImage())
                .into(holder.imageV);
        holder.cartPlusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managerCart.plusNumberFood(listFoodCart, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });

        holder.cartMinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managerCart.minusNumberFood(listFoodCart, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFoodCart.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageV, cartPlusBtn, cartMinusBtn;
        TextView foodNameV, priceV, tvFoodQuantity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageV = itemView.findViewById(R.id.cart_img);
            foodNameV = itemView.findViewById(R.id.tvFoodName);
            priceV = itemView.findViewById(R.id.tvFoodPrice);
            cartPlusBtn = itemView.findViewById(R.id.cart_plus_btn);
            cartMinusBtn = itemView.findViewById(R.id.cart_minus_btn);
            tvFoodQuantity = itemView.findViewById(R.id.tvFoodQuantity);
        }
    }
}