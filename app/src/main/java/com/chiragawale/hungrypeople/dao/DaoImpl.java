package com.chiragawale.hungrypeople.dao;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.chiragawale.hungrypeople.data.model.Business;
import com.chiragawale.hungrypeople.data.model.FoodItem;
import com.chiragawale.hungrypeople.data.model.Order;
import com.chiragawale.hungrypeople.data.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DaoImpl implements Dao {
    /*
            USER RELATED METHODS
     */
    @Override
    public void addUser() {

    }

    @Override
    public User getUserData(String userID) {
        //Dummy Data
        final ArrayList<String> orders = new ArrayList<String>();
        orders.add("12345");
        orders.add("12346");
        orders.add("12347");
        orders.add("12348");
        User Jane = new User("JD", "Jane", "Doe", "3343343344", "jd@email.com", "Ghar", orders);
//        String djangoEndpoint = "";
//        final ArrayList <User> userData = new ArrayList<User>();
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, djangoEndpoint, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                        JSONObject result = response.getJSONObject("User");
//                        String userName = result.getString("userName");
//                        String firstName = result.getString("firstName");
//                        String lastName = result.getString("lastName");
//                        String phoneNumber = result.getString("phoneNumber");
//                        String emailAddress = result.getString("emailAddress");
//                        String address = result.getString("address");
//                        JSONArray orderHistory = result.getJSONArray("orderHistory");
//                        ArrayList<String> orderHistoryIDs = new ArrayList<String>();
//                        for (int j = 0; j<orderHistory.length(); j++) {
//                            JSONObject order = orderHistory.getJSONObject(j);
//                            String orderId = order.getString("orderId");
//                            orderHistoryIDs.add(orderId);
//                        }
//                        userData.add(new User(userName, firstName, lastName, phoneNumber, emailAddress, address, orderHistoryIDs));
//
//
//                } catch (JSONException e) {
//                    Log.e("HP", "Json error", e);
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError e) {
//                Log.e("HP", "User list error" + e.getMessage());
//                Log.e("HP", userDataList.toString());
//            }
//        });
        return Jane;
    }

    @Override
    public ArrayList<Business> getNearbyBusinessData(String businessID) {
        ArrayList<Business> businessList = new ArrayList<>();
        // Get request

        // json paraser
        return null;
    }

    @Override
    public ArrayList<Order> getUserOrderList(String userID) {
        return null;
    }

    @Override
    public ArrayList<User> getUserList() {

        final ArrayList<User> userDataList = new ArrayList<User>();

        //Dummy Data
        final ArrayList<String> orders = new ArrayList<String>();
        orders.add("12345");
        orders.add("12346");
        orders.add("12347");
        orders.add("12348");
        userDataList.add(new User("rojan", "Rojan", "Maharjan", "3344921559", "rojanm874@gmail.com", "NFranklin", orders));
        userDataList.add(new User("chirag", "Chirag", "Awale", "3344921560", "chirag@gmail.com", "NFranklin", orders));
        userDataList.add(new User("Smit", "Smit", "Shrestha", "3344921561", "smit@gmail.com", "NFranklin", orders));

//        String djangoEndpoint = "";
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, djangoEndpoint, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray results = response.getJSONArray("Users");
//                    for (int i = 0; i < results.length(); i++) {
//                        JSONObject result = results.getJSONObject(i);
//                        String userName = result.getString("userName");
//                        String firstName = result.getString("firstName");
//                        String lastName = result.getString("lastName");
//                        String phoneNumber = result.getString("phoneNumber");
//                        String emailAddress = result.getString("emailAddress");
//                        String address = result.getString("address");
//                        JSONArray orderHistory = result.getJSONArray("orderHistory");
//                        ArrayList<String> orderHistoryIDs = new ArrayList<String>();
//                        for (int j = 0; j<orderHistory.length(); i++){
//                            JSONObject order = orderHistory.getJSONObject(j);
//                            String orderId = order.getString("orderId");
//                            orderHistoryIDs.add(orderId);
//                        }
//
//                        userDataList.add(new User(userName, firstName, lastName, phoneNumber, emailAddress, address, orderHistoryIDs));
//
//                    }
//
//                } catch (JSONException e) {
//                    Log.e("HP", "Json error", e);
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError e) {
//                Log.e("HP", "User list error" + e.getMessage());
//                Log.e("HP", userDataList.toString());
//            }
//        });
        return userDataList;
    }


    /*
           ORDER RELATED METHODS
    */

    @Override
    public void createNewOrder(String userID, String businessID, ArrayList<FoodItem> orderItems) {

    }

    @Override
    public ArrayList<Business> getBusinessList() {
        String djangoEndpoint = "";
        final ArrayList<Business> businessDataList = new ArrayList<Business>();

        //Dummy Data
        final ArrayList<String> orders = new ArrayList<String>();
        orders.add("12345");
        orders.add("12346");
        orders.add("12347");
        orders.add("12348");

        final ArrayList<FoodItem> menu = new ArrayList<FoodItem>();
        menu.add(new FoodItem("1","MoMo","5.99", "Mitho"));
        menu.add(new FoodItem("2","Bhat","7.99", "Atti Mitho"));
        menu.add(new FoodItem("3","Chowmein","4.99", "Thikkai Mitho"));

        businessDataList.add(new Business("1", "Rojan", "3344921559", "rojanm874@gmail.com", "NFranklin", menu, orders));
        businessDataList.add(new Business("2", "Chirag", "3344921560", "chirag@gmail.com", "NFranklin", menu, orders));
        businessDataList.add(new Business("3", "Smit",  "3344921561", "smit@gmail.com", "NFranklin", menu, orders));

//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, djangoEndpoint, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray results = response.getJSONArray("Businesses");
//                    for (int i = 0; i < results.length(); i++) {
//                        JSONObject result = results.getJSONObject(i);
//                        String businessID = result.getString("businessID");
//                        String businessName = result.getString("businessName");
//                        String phoneNumber = result.getString("lastName");
//                        String emailAddress = result.getString("phoneNumber");
//                        String address = result.getString("emailAddress");
//
//                        JSONArray orderHistory = result.getJSONArray("orderHistory");
//                        ArrayList<String> orderHistoryIDs = new ArrayList<String>();
//                        for (int j = 0; j<orderHistory.length(); i++){
//                            JSONObject order = orderHistory.getJSONObject(j);
//                            String orderId = order.getString("orderId");
//                            orderHistoryIDs.add(orderId);
//                        }
//
//                        userDataList.add(new Business(businessID, businessName, phoneNumber, emailAddress, menu, orderHistoryIDs));
//
//                    }
//
//                } catch (JSONException e) {
//                    Log.e("HP", "Json error", e);
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError e) {
//                Log.e("HP", "User list error" + e.getMessage());
//                Log.e("HP", userDataList.toString());
//            }
//        });
        return businessDataList;
    }


    /*
           BUSINESS RELATED METHODS
    */
    @Override
    public Business getBusinessData(String businessID) {
        return null;
    }

    @Override
    public ArrayList<Order> getBusinessOrderList(String businessID) {
        return null;
    }


}
