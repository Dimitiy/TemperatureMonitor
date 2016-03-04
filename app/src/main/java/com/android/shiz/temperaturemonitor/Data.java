package com.android.shiz.temperaturemonitor;

/**
 * Created by OldMan on 29.02.2016.
 */
public class Data {
    public static String getError() {
        return error;
    }

    public static void setError(String error) {
        Data.error = error;
    }

    private static String error = "";
    public static String getMAC() {
        return MAC;
    }

    public static void setMAC(String MAC) {
        Data.MAC = MAC;
    }

    private static String MAC = "";

    public static float getTemperature() {
        return temperature;
    }

    public static void setTemperature(float temperature) {
        Data.temperature = temperature;
    }

    private static float temperature = 0;

}
