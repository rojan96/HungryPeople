package com.chiragawale.hungrypeople.Profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.chiragawale.hungrypeople.App;
import com.chiragawale.hungrypeople.R;
import com.chiragawale.hungrypeople.data.model.User;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String userID = "1";                            //TODO Update profile with real data
        User user = App.dao.getUserData(userID);
        ArrayList <String> orders = new ArrayList<String>();

        String userName = user.getUserName();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String phoneNumber = user.getPhoneNumber();
        String emailAddress = user.getEmailAddress();
        String address = user.getAddress();

        final TextView username = (TextView) findViewById(R.id.username);
        String welcomeUser = "Welcome, " + userName+".";
        username.setText(welcomeUser);
        final TextView firstname = (TextView) findViewById(R.id.firstname);
        firstname.setText(firstName);
        final TextView lastname = (TextView) findViewById(R.id.lastname);
        lastname.setText(lastName);
        final TextView phonenumber = (TextView) findViewById(R.id.phonenumber);
        phonenumber.setText(phoneNumber);
        final TextView emailaddress = (TextView) findViewById(R.id.emailaddress);
        emailaddress.setText(emailAddress);
        final TextView homeAddress = (TextView) findViewById(R.id.address);
        homeAddress.setText(address);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new OrderAdapter();
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
