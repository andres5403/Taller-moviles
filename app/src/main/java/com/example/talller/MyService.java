package com.example.talller;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    public void onCreate() {
        super.onCreate();

    }








    @Override
    public IBinder onBind(Intent intent) {
        return  null;
    }
}