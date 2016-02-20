package com.android.shiz.temperaturemonitor;

import android.app.Application;

import com.android.shiz.temperaturemonitor.listener.TemperatureObservable;

/**
 * Created by OldMan on 21.02.2016.
 */
public class App extends Application {
    TemperatureObservable mTemperature;

    @Override
    public void onCreate() {
        super.onCreate();

        mTemperature = new TemperatureObservable();
    }

    public TemperatureObservable getObserver() {
        return mTemperature;
    }

}
