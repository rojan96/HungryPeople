package com.chiragawale.hungrypeople.data.model;

public class OrderItem {
    private String orderID;
    private String foodName;
    private String foodPrice;

    public OrderItem(String orderID, String foodName, String foodPrice) {
        this.orderID = orderID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }
}
