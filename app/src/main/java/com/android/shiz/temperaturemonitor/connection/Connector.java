package com.android.shiz.temperaturemonitor.connection;

import android.support.annotation.NonNull;

import com.android.shiz.temperaturemonitor.listener.Observer;
import com.android.shiz.temperaturemonitor.listener.TemperatureDataObject;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by OldMan on 20.02.2016.
 */
public class Connector implements Observer {
    public static final String API_URL = "http://192.168.0.1:10080/";

    private static final OkHttpClient CLIENT = new OkHttpClient();

    public Connector() {
        TemperatureDataObject temperatureDataObject = new TemperatureDataObject();
        temperatureDataObject.addObserver(this);

    }

    @NonNull
    public static ServerService getService() {
        return getRetrofit().create(ServerService.class);
    }

    @NonNull
    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void temperatureChanged(float temperature) {

        // Prepare the HTTP request
        Call<ServerService> call = getService().sendDegree(new Request("ID-1", temperature), new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (!response.isSuccess()) {
                    // print response body if unsuccessful
                    try {
                        System.out.println(response.errorBody().string());
                    } catch (IOException e) {
                        // do nothing
                    }
                    return;
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                System.out.println("onFailure");
                System.out.println(t.getMessage());
            }
        });

    }

}