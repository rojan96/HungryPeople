package com.chiragawale.hungrypeople.dao;

import android.content.Context;
import android.util.Log;


import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.chiragawale.hungrypeople.Profile.OrderAdapter;
import com.chiragawale.hungrypeople.data.model.Business;
import com.chiragawale.hungrypeople.data.model.FoodItem;
import com.chiragawale.hungrypeople.data.model.Order;
import com.chiragawale.hungrypeople.data.model.OrderItem;
import com.chiragawale.hungrypeople.data.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DaoImpl implements Dao {

    final String BASE_API = "https://hungrypeople.ue.r.appspot.com/api/";
    final String ORDER  = "order/";
    final String BUSINESS  = "business/";
    final String ORDERITEM  = "orderitem/";
    final String FOOD  = "food/";

    private static ArrayList<User> globalUserList = new ArrayList<>();
    /*
            USER RELATED METHODS
     */


    @Override
    public ArrayList<User> getGlobalList(Context context) {
        return globalUserList;
    }

    @Override
    public void addUser() {

    }

    @Override
    public User getUserData(String userID) {
        //Dummy Data
        User Jane = new User("JD", "Jane", "Doe", true,"JD SHOP","Ghar","3343343344", "jd@email.com", "9-10", "pasal" );

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
    public ArrayList<Order> getUserOrderList(Context context) {
        final ArrayList<Order> orderList = new ArrayList<Order>();

        return loadOrderList(orderList, context);

    }

    @Override
    public ArrayList<Order> loadOrderList(final ArrayList<Order> userOrderList, Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        String djangoEndpoint = BASE_API + ORDER;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, djangoEndpoint, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONArray results = response;
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject result = results.getJSONObject(i);
                        String id = result.getString("id");
                        String user_id = result.getString("user_id");
                        String business_id = result.getString("business_id");
                        String order_receive_method = result.getString("order_receive_method");
                        String pickup_time = result.getString("pickup_time");
                        String placed_time = result.getString("placed_time");

                        userOrderList.add(new Order(id, user_id, business_id, order_receive_method, pickup_time, placed_time));
//                        Log.e("HP", userDataList.toString());
                    }

                } catch (JSONException e) {
                    Log.e("HP", "Json error", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Log.e("HP", "User list error" + e.getMessage());

            }
        });
        requestQueue.add(request);
        return userOrderList;
    }

    @Override
    public ArrayList<OrderItem> getOrderItemList(Context context) {
        ArrayList<OrderItem> userOrderItemList = new ArrayList<OrderItem>();
//        userOrderItemList = loadOrderItemList( context);
        return userOrderItemList;
    }

    @Override
    public ArrayList<OrderItem> loadOrderItemList(Context context, final OrderAdapter adapter) {
        final ArrayList<OrderItem> userOrderList = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        String djangoEndpoint = BASE_API + ORDERITEM;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, djangoEndpoint, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONArray results = response;
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject result = results.getJSONObject(i);
                        String order_id = result.getString("order_id");
                        String food_name = result.getString("food_name");
                        String food_price = result.getString("food_price");
                        Log.e("Order item", order_id + "order item");
                        userOrderList.add(new OrderItem(order_id, food_name, food_price));
//                        Log.e("HP", userDataList.toString());
                    }
                    adapter.setOrderItems(userOrderList);
                    adapter.notifyDataSetChanged();
                    Log.e("notify", "Notifying data set changed");
                } catch (JSONException e) {
                    Log.e("HP", "Json error", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Log.e("HP", "User list error" + e.getMessage());

            }
        });
        requestQueue.add(request);
        return userOrderList;
    }

    @Override
    public ArrayList<FoodItem> getFoodItemList(Context context) {
        final ArrayList<FoodItem> foodItemArrayList = new ArrayList<>();
        return loadFoodItemList(foodItemArrayList, context);
    }

    @Override
    public ArrayList<FoodItem> loadFoodItemList(final ArrayList<FoodItem> foodItemArrayList, Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        String djangoEndpoint = BASE_API + FOOD;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, djangoEndpoint, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONArray results = response;
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject result = results.getJSONObject(i);
                        String id = result.getString("id");
                        String user_id = result.getString("user_id");
                        String food_name = result.getString("food_name");
                        String food_price = result.getString("food_price");
                        String description = result.getString("description");
                        String tags = result.getString("tags");
                        foodItemArrayList.add(new FoodItem(id, user_id, food_name, food_price, description, tags));

                    }

                } catch (JSONException e) {
                    Log.e("HP", "Json error", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Log.e("HP", "User list error" + e.getMessage());

            }
        });
        requestQueue.add(request);
        return foodItemArrayList;
    }

    @Override
    public ArrayList<User> getUserList(Context context) {

        final ArrayList<User> userDataList = new ArrayList<User>();

        //Dummy Data

        return loadUserList(userDataList, context);

    }



    public ArrayList<User> loadUserList(final ArrayList<User> userDataList, Context context) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        String djangoEndpoint = BASE_API + BUSINESS;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, djangoEndpoint, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONArray results = response;
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject result = results.getJSONObject(i);
                        String userName = result.getString("username");
                        String firstName = result.getString("first_name");
                        String lastName = result.getString("last_name");
                        Boolean iscustomer = result.getBoolean("iscustomer");
                        String businessName = result.getString("business_name");
                        String address = result.getString("full_address");
                        String phoneNumber = result.getString("phone_number");
                        String emailAddress = result.getString("email_address");
                        String openHours = result.getString("open_hours");
                        String businessAddress = result.getString("business_address");

//
                        userDataList.add(new User(userName, firstName, lastName, iscustomer, businessName, address, phoneNumber, emailAddress, openHours, businessAddress));
//                        Log.e("HP", userDataList.toString());

                    }
                    globalUserList = userDataList;
                } catch (JSONException e) {
                    Log.e("HP", "Json error", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Log.e("HP", "User list error" + e.getMessage());

            }
        });
        requestQueue.add(request);
        return userDataList;
    }


    /*
           ORDER RELATED METHODS
    */

    @Override
    public void createNewOrder(String userID, String businessID, ArrayList<FoodItem> orderItems) {

    }



    @Override
    public  ArrayList<Business> getBusinessList() {
//        String djangoEndpoint = "";
//        final ArrayList<Business> businessDataList = new ArrayList<Business>();
//
//        //Dummy Data
//        final ArrayList<String> orders = new ArrayList<String>();
//        orders.add("12345");
//        orders.add("12346");
//        orders.add("12347");
//        orders.add("12348");
//
//        final ArrayList<FoodItem> menu = new ArrayList<FoodItem>();
//        menu.add(new FoodItem("1","MoMo","5.99", "Mitho"));
//        menu.add(new FoodItem("2","Bhat","7.99", "Atti Mitho"));
//        menu.add(new FoodItem("3","Chowmein","4.99", "Thikkai Mitho"));
//        menu.add(new FoodItem("4","Chowmeinwe","4.99", "Thikkai Mitho al"));
//
//        businessDataList.add(new Business("1", "Rojan", "3344921559", "rojanm874@gmail.com", "NFranklin", menu, orders));
//        businessDataList.add(new Business("2", "Chirag", "3344921560", "chirag@gmail.com", "NFranklin", menu, orders));
//        businessDataList.add(new Business("3", "Smit",  "3344921561", "smit@gmail.com", "NFranklin", menu, orders));

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
        return null;
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
