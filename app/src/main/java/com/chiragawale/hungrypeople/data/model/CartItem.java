package com.chiragawale.hungrypeople.data.model;

public class CartItem {
    String id, foodName, foodPrice, foodItemId;

    public CartItem(String id, String foodName, String foodPrice, String foodItemId) {
        this.id = id;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodItemId = foodItemId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(String foodItemId) {
        this.foodItemId = foodItemId;
    }
}
