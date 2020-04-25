package com.chiragawale.hungrypeople.data.model;

public class FoodItem {
    private String foodItemID;
    private String foodName;
    private String foodPrice;
    private String foodDescription;

    public FoodItem(String foodItemID, String foodName, String foodPrice, String foodDescription) {
        this.foodItemID = foodItemID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodDescription = foodDescription;
    }

    public String getFoodItemID() {
        return foodItemID;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public String getFoodDescription() {
        return foodDescription;
    }
}
