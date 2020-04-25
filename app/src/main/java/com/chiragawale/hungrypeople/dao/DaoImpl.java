package com.chiragawale.hungrypeople.dao;

import com.chiragawale.hungrypeople.data.model.Business;
import com.chiragawale.hungrypeople.data.model.FoodItem;
import com.chiragawale.hungrypeople.data.model.Order;
import com.chiragawale.hungrypeople.data.model.User;

import java.util.ArrayList;

public class DaoImpl implements Dao {
    /*
            USER RELATED METHODS
     */
    @Override
    public void addUser() {

    }

    @Override
    public User getUserData(String userID) {
        return null;
    }

    @Override
    public ArrayList<Business> getNearbyBusinessData(String businessID) {
        ArrayList<Business> businessList = new ArrayList<>();
        // Get request

        // json paraser
        return null;
    }

    @Override
    public ArrayList<Order> getUserOrderList(String userID) {
        return null;
    }

    @Override
    public ArrayList<User> getUserList() {
        return null;
    }


    /*
           ORDER RELATED METHODS
    */

    @Override
    public void createNewOrder(String userID, String businessID, ArrayList<FoodItem> orderItems) {

    }

    @Override
    public ArrayList<Business> getBusinessList() {
        return null;
    }


    /*
           BUSINESS RELATED METHODS
    */
    @Override
    public Business getBusinessData(String businessID) {
        return null;
    }

    @Override
    public ArrayList<Order> getBusinessOrderList(String businessID) {
        return null;
    }


}
