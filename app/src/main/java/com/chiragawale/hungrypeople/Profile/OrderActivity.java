package com.chiragawale.hungrypeople.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chiragawale.hungrypeople.R;

public class OrderActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView numberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        String name = getIntent().getStringExtra("name");

        nameTextView = findViewById(R.id.order_details);
        nameTextView.setText(name);
    }
}
