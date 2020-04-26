package com.chiragawale.hungrypeople.Home.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chiragawale.hungrypeople.R;
import com.chiragawale.hungrypeople.dao.Dao;
import com.chiragawale.hungrypeople.dao.DaoImpl;
import com.chiragawale.hungrypeople.data.model.User;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Dao dao = new DaoImpl();
        User user = dao.getUserData("1");
        ArrayList <String> orders = new ArrayList<String>();

        String userName = user.getUserName();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String phoneNumber = user.getPhoneNumber();
        String emailAddress = user.getEmailAddress();
        String address = user.getAddress();
        orders = user.getOrderHistory();

        final TextView username = (TextView) findViewById(R.id.username);
        username.setText(userName);

    }
}
