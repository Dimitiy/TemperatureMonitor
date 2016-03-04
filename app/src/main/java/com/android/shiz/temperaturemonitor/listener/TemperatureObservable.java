package com.android.shiz.temperaturemonitor.listener;

import com.android.shiz.temperaturemonitor.connection.Connector;
import com.android.shiz.temperaturemonitor.connection.Request;

import java.util.Observable;

/**
 * Created by OldMan on 19.02.2016.
 */
public class TemperatureObservable extends Observable {

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(String dev, float temperature) {
        this.temperature = temperature;
        Request request = new Request(dev, temperature);
        Connector.sendRequest(request);
        notifyObservers(this.temperature);
    }

    private float temperature;

}
