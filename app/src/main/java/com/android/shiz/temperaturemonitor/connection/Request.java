package com.android.shiz.temperaturemonitor.connection;

import java.util.Map;

/**
 * Created by OldMan on 20.02.2016.
 */
public class Request {
    public Request(String dev, float value) {
        this.value = value;
        this.dev = dev;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    private float value;

    public String getDev() {
        return dev;
    }

    public void setDev(String dev) {
        this.dev = dev;
    }

    private String dev;

}
