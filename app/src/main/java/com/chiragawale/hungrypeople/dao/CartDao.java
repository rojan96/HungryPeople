package com.chiragawale.hungrypeople.dao;

import android.content.Context;

import com.chiragawale.hungrypeople.data.model.FoodItem;

public interface CartDao {
    public void addToCart(FoodItem foodItem, Context context);
    public void clearCart(Context context);
    public void removeItemFromCart(String id, Context context);
    public void getAllItemsFromCart(Context context);
}
