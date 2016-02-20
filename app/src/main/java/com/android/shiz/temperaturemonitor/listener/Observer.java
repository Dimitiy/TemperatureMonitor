package com.android.shiz.temperaturemonitor.listener;

import java.util.Objects;

/**
 * Created by OldMan on 19.02.2016.
 */
public interface Observer {
    public void temperatureChanged(float temperature);
}
