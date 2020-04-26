package com.chiragawale.hungrypeople.data.model;

import java.util.ArrayList;

public class Order {
    private String orderID;
    private String userID;
    private String businessID;
    private String orderReceiveMethod;
    private String pickupTime;
    private String date;
    private float total;

    ArrayList<FoodItem> orderItems = new ArrayList<FoodItem>();

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBusinessID() {
        return businessID;
    }

    public void setBusinessID(String businessID) {
        this.businessID = businessID;
    }

    public String getOrderReceiveMethod() {
        return orderReceiveMethod;
    }

    public void setOrderReceiveMethod(String orderReceiveMethod) {
        this.orderReceiveMethod = orderReceiveMethod;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public Order(String orderID, String userID, String businessID, String orderReceiveMethod, String pickupTime, String date) {
        this.orderID = orderID;
        this.userID = userID;
        this.businessID = businessID;
        this.orderReceiveMethod = orderReceiveMethod;
        this.pickupTime = pickupTime;
        this.date = date;

    }
}
