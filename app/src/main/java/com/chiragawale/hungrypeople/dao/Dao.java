package com.chiragawale.hungrypeople.dao;

import android.content.Context;

import com.chiragawale.hungrypeople.data.model.Business;
import com.chiragawale.hungrypeople.data.model.FoodItem;
import com.chiragawale.hungrypeople.data.model.Order;
import com.chiragawale.hungrypeople.data.model.OrderItem;
import com.chiragawale.hungrypeople.data.model.User;

import java.util.ArrayList;

public interface Dao {
    //User related methods
    void addUser();
    public ArrayList<User> loadUserList(final ArrayList<User> userDataList, Context context);
    User getUserData(String userID);
    ArrayList<Business> getNearbyBusinessData(String searchTerm);
    ArrayList<Order> getUserOrderList(Context context);
    ArrayList<User> getUserList(Context context);

    //Food related methods
    ArrayList<FoodItem> getFoodItemList(Context context);
    ArrayList<FoodItem> loadFoodItemList(ArrayList<FoodItem> foodItemArrayList, Context context);



    //order related methods
    void createNewOrder(String userID, String businessID, ArrayList<FoodItem> orderItems);
    ArrayList<OrderItem> getOrderItemList(Context context);
    public ArrayList<Order> loadOrderList(final ArrayList<Order> userOrderList, Context context);
    public ArrayList<OrderItem> loadOrderItemList(final ArrayList<OrderItem> userOrderList, Context context);



    //business related methods
    ArrayList<Business> getBusinessList();
    Business getBusinessData(String businessID);
    ArrayList<Order> getBusinessOrderList(String businessID);
}
