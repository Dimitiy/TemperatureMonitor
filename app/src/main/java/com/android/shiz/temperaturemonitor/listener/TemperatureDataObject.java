package com.android.shiz.temperaturemonitor.listener;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OldMan on 19.02.2016.
 */
public class TemperatureDataObject implements Observable<Observer>{
    private List<Observer> listeners = new ArrayList<Observer>();

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers(this.temperature);
    }

    private float temperature;


    @Override
    public void addObserver(Observer listener) {
        listeners.add(listener);
        Log.d("TemperatureDataObject", "addObserver" + listener);
    }

    @Override
    public void removeObserver(Observer listener) {
        Log.d("TemperatureDataObject", "removeObserver" + listener);
        listeners.remove(listener);

    }
    @Override
    public void notifyObservers(float temperature) {
        for(Observer listener: listeners)
            listener.temperatureChanged(temperature);
    }
}
