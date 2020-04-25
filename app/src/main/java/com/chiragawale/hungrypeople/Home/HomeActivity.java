package com.chiragawale.hungrypeople.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.chiragawale.hungrypeople.Home.ui.home.HomeFragment;
import com.chiragawale.hungrypeople.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, HomeFragment.newInstance())
                    .commitNow();
        }
    }
}
