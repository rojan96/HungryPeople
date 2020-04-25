package com.chiragawale.hungrypeople.data.model;

import java.util.ArrayList;

public class Business {
    private String businessID;
    private String businessName;
    private String phoneNumber;
    private String emailAddress;
    private String address;

    ArrayList<FoodItem> menu = new ArrayList<FoodItem>();
    ArrayList<Order> orderHistory = new ArrayList<Order>();

    public Business(String businessID, String businessName, String phoneNumber, String emailAddress, String address, ArrayList<FoodItem> menu, ArrayList<Order> orderHistory) {
        this.businessID = businessID;
        this.businessName = businessName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.menu = menu;
        this.orderHistory = orderHistory;
    }

    public void setMenu(ArrayList<FoodItem> menu) {
        this.menu = menu;
    }

    public ArrayList<FoodItem> getMenu() {
        return menu;
    }

    public String getBusinessID() {
        return businessID;
    }

    public void setBusinessID(String businessID) {
        this.businessID = businessID;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(ArrayList<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }
}
