package com.chiragawale.hungrypeople.dao;

import com.chiragawale.hungrypeople.data.model.Business;
import com.chiragawale.hungrypeople.data.model.FoodItem;
import com.chiragawale.hungrypeople.data.model.Order;
import com.chiragawale.hungrypeople.data.model.User;

import java.util.ArrayList;

public interface Dao {

    //User related methods
    void addUser();
    User getUserData(String userID);
    ArrayList<Business> getNearbyBusinessData(String searchTerm);
    ArrayList<Order> getUserOrderList(String userID);
    ArrayList<User> getUserList();


    //order related methods
    void createNewOrder(String userID, String businessID, ArrayList<FoodItem> orderItems);


    //business related methods
    ArrayList<Business> getBusinessList();
    Business getBusinessData(String businessID);
    ArrayList<Order> getBusinessOrderList(String businessID);
}
