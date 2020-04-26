package com.chiragawale.hungrypeople.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.chiragawale.hungrypeople.App;
import com.chiragawale.hungrypeople.R;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        RecyclerView recyclerView = findViewById(R.id.rv_cart);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new CartAdapter(getApplicationContext(),App.cartDao.getAllItemsFromCart(getApplicationContext()));
        recyclerView.setAdapter(mAdapter);
    }
}
