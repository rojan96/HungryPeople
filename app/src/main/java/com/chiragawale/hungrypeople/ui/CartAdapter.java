package com.chiragawale.hungrypeople.ui;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chiragawale.hungrypeople.App;
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolderMyLife) holder).tv_name.setText(dataset.get(position).getFoodName());
        ((ViewHolderMyLife) holder).tv_price.setText(dataset.get(position).getFoodPrice());
        ((ViewHolderMyLife) holder).ib_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                App.cartDao.removeItemFromCart(dataset.get(position).getId(),context);
                dataset.clear();
                dataset = App.cartDao.getAllItemsFromCart(context);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    class ViewHolderMyLife extends RecyclerView.ViewHolder {
        TextView tv_price,tv_name;
        ImageButton ib_delete;

        public ViewHolderMyLife(View itemView) {
            super(itemView);
            ib_delete = itemView.findViewById(R.id.ic_delete);
            tv_price = itemView.findViewById(R.id.tv_foodprice);
            tv_name = itemView.findViewById(R.id.tv_foodname);
        }

    }

}
