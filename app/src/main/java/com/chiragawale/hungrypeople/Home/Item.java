package com.chiragawale.hungrypeople.Home;

import android.view.View;

import java.util.ArrayList;

public class Item {
    private String name;
    private String address;
    private String hours;
    private String category;


    private View.OnClickListener requestBtnClickListener;

    public Item() {
    }

    public Item(String name, String address, String hours, String category) {
        this.name = name;
        this.address = address;
        this.hours = hours;
        this.category = category;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Item item = (Item) o;
//
//        if (name != null ? !name.equals(item.name) : item.name != null) return false;
//        if (address != null ? !address.equals(item.address) : item.address != null)
//            return false;
//        if (hours != null ? !hours.equals(item.hours) : item.hours != null)
//            return false;
//        if (category != null ? !category.equals(item.category) : item.category != null)
//            return false;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + (address != null ? address.hashCode() : 0);
//        result = 31 * result + (category != null ? category.hashCode() : 0);
//        result = 31 * result + (hours != null ? hours.hashCode() : 0);
//        return result;
//    }

    /**
     * @return List of elements prepared for tests
     */
    public static ArrayList<Item> getTestingList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Raju", "Baraghare", "8 AM - 10 PM","Bhatti"));
        items.add(new Item("Raju", "Baraghare", "8 AM - 10 PM","Bhatti"));
        items.add(new Item("Raju", "Baraghare", "8 AM - 10 PM","Bhatti"));
        items.add(new Item("Raju", "Baraghare", "8 AM - 10 PM","Bhatti"));
        items.add(new Item("Raju", "Baraghare", "8 AM - 10 PM","Bhatti"));
        return items;

    }
}
