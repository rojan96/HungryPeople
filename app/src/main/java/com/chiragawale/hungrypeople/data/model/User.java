package com.chiragawale.hungrypeople.data.model;

import java.util.ArrayList;

public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String address;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public User(String userName, String firstName, String lastName, String phoneNumber, String emailAddress, String address, ArrayList<String> orderHistory) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.orderHistory = orderHistory;
    }

    ArrayList<String> orderHistory = new ArrayList<String>();
}
