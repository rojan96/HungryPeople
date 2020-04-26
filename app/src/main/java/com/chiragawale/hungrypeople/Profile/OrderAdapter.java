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

import java.util.Arrays;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout containerView;
        public TextView textView;

        OrderViewHolder(View view) {
            super(view);
            containerView = view.findViewById(R.id.order_row);
            textView = view.findViewById(R.id.order_row_text_view);

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

    private List<String> order = Arrays.asList(
            "Order 1",
            "Order 2",
            "Order 3",
            "Order 4"
    );

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_row, parent, false);

        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        String current = order.get(position);
        holder.textView.setText(current);
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return order.size();
    }
}
