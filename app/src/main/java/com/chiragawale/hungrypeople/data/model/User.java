package com.chiragawale.hungrypeople.data.model;

import java.util.ArrayList;

public class User {
    private String userID;
    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String address;

    ArrayList<Order> orderHistory = new ArrayList<Order>();

    public User(String userID, String userName, String firstName, String lastName, String phoneNumber, String emailAddress, String address, ArrayList<Order> orderHistory) {
        this.userID = userID;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.orderHistory = orderHistory;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }


}
