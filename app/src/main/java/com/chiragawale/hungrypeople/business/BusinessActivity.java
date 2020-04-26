package com.chiragawale.hungrypeople.business;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.chiragawale.hungrypeople.R;
import com.chiragawale.hungrypeople.business.ui.business.BusinessFragment;

public class BusinessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, BusinessFragment.newInstance())
                    .commitNow();
        }
    }
}
