package com.chiragawale.hungrypeople.data.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private Boolean iscustomer;
    private String businessName;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String openHours;
    private String businessAddress;

    public Boolean getIscustomer() {
        return iscustomer;
    }

    public void setIscustomer(Boolean iscustomer) {
        this.iscustomer = iscustomer;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

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




    public User(String userName, String firstName, String lastName, Boolean iscustomer, String businessName, String address, String phoneNumber, String emailAddress,  String openHours, String businessAddress) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.iscustomer = iscustomer;
        this.businessName = businessName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.openHours = openHours;
        this.businessAddress = businessAddress;
    }

}
