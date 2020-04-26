package com.chiragawale.hungrypeople.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chiragawale.hungrypeople.R;
import com.chiragawale.hungrypeople.data.model.CartItem;
import com.chiragawale.hungrypeople.data.model.FoodItem;

import java.util.List;

public class CartAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private  Context context;
    List<CartItem> dataset;
    public CartAdapter(Context context, List<CartItem> dataset) {
        this.context = context;
        this.dataset = dataset;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        return new ViewHolderMyLife(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolderMyLife) holder).tv_name.setText(dataset.get(position).getFoodName());
        ((ViewHolderMyLife) holder).tv_price.setText(dataset.get(position).getFoodPrice());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    class ViewHolderMyLife extends RecyclerView.ViewHolder {
        TextView tv_price,tv_name;

        public ViewHolderMyLife(View itemView) {
            super(itemView);
            tv_price = itemView.findViewById(R.id.tv_foodprice);
            tv_name = itemView.findViewById(R.id.tv_foodname);
        }

    }

}
