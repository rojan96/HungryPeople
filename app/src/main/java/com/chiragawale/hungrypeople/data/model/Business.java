package com.chiragawale.hungrypeople.data.model;

import android.view.View;

import java.util.ArrayList;

public class Business {
    private String businessID;
    private String businessName;
    private String phoneNumber;
    private String emailAddress;
    private String address;

    ArrayList<FoodItem> menu = new ArrayList<FoodItem>();
    ArrayList<String> orderHistory = new ArrayList<String>();
    private View.OnClickListener requestBtnClickListener;

    public Business(String businessID, String businessName, String phoneNumber, String emailAddress, String address, ArrayList<FoodItem> menu, ArrayList<String> orderHistory) {
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

    public ArrayList<String> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(ArrayList<String> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }

}
