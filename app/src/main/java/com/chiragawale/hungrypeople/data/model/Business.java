package com.chiragawale.hungrypeople.data.model;

import java.util.ArrayList;

public class Business {
    private String businessID;
    private String businessName;
    private String phoneNumber;
    private String emailAddress;
    private String address;

    ArrayList<Order> orderHistory = new ArrayList<Order>();

}
