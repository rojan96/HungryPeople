package com.chiragawale.hungrypeople;

import android.app.Application;

import com.chiragawale.hungrypeople.dao.Dao;
import com.chiragawale.hungrypeople.dao.DaoImpl;

public class App extends Application {
    public final static Dao dao = new DaoImpl();
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
