package com.chiragawale.hungrypeople.Profile;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chiragawale.hungrypeople.R;
import com.chiragawale.hungrypeople.data.model.OrderItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout containerView;
        public TextView tv_name,tv_price;

        OrderViewHolder(View view) {
            super(view);
            tv_name = view.findViewById(R.id.tv_name);
            tv_price = view.findViewById(R.id.tv_price);

            containerView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    String current = (String) containerView.getTag();
                    Intent intent = new Intent(view.getContext(), OrderActivity.class);
                    intent.putExtra("name", current);
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    private List<OrderItem> orderItem;

    public OrderAdapter(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_row, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        String current = orderItem.get(position).getFoodName();
        holder.tv_name.setText(orderItem.get(position).getFoodName());
        holder.tv_price.setText(orderItem.get(position).getFoodPrice());
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return orderItem.size();
    }
}
