package com.android.shiz.temperaturemonitor;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.android.shiz.temperaturemonitor.listener.TemperatureObservable;

/**
 * Created by OldMan on 21.02.2016.
 */
public class App extends Application {
    TemperatureObservable mTemperature;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
        mTemperature = new TemperatureObservable();
    }

    public static String getIP(){
       SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
       return sp.getString("ip", "192.168.0.1");
    }
    public static void setIP(String ip){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("ip", ip);
        ed.commit();
    }
    public TemperatureObservable getObserver() {
        return mTemperature;
    }

}
