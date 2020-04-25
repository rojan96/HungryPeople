package com.chiragawale.hungrypeople.data.model;

import java.util.ArrayList;

public class Order {
    private String orderID;
    private String userID;
    private String businessID;
    private String orderReceiveMethod;
    private String pickupTime;

    ArrayList<FoodItem> orderItems = new ArrayList<FoodItem>();

    public Order(String orderID, String userID, String businessID, String orderReceiveMethod, String pickupTime, ArrayList<FoodItem> orderItems) {
        this.orderID = orderID;
        this.userID = userID;
        this.businessID = businessID;
        this.orderReceiveMethod = orderReceiveMethod;
        this.pickupTime = pickupTime;
        this.orderItems = orderItems;
    }

    public String getOrderID(){ return orderID ; }
    public String getUserID(){ return userID ; }
    public String getBusinessID(){ return businessID ; }

    public void setOrderItems(ArrayList<FoodItem> orderItems) {
        this.orderItems = orderItems;
    }
}
