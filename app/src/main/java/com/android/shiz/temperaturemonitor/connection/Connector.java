package com.android.shiz.temperaturemonitor.connection;

import android.support.annotation.NonNull;
import android.util.Log;

import com.android.shiz.temperaturemonitor.App;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by OldMan on 20.02.2016.
 */
public class Connector {
    private static final String LOG_TAG = Connector.class.getSimpleName();
    public static final String API_URL = "http://192.168.0.31:8080/";
    App app;
    private static final OkHttpClient CLIENT = new OkHttpClient();

    @NonNull
    private static ServerService getService() {
        return getRetrofit().create(ServerService.class);
    }

    @NonNull
    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static void sendRequest(Request request) {
        // Prepare the HTTP request
        Log.d("Connector", "degree " + request.getValue());
        Call<ServerService> call = getService().sendDegree(request.getDev(), String.valueOf(request.getValue()));
        call.enqueue(new Callback<ServerService>() {
            @Override
            public void onResponse(Call<ServerService> call, Response<ServerService> response) {
                Log.d(LOG_TAG, "onResponse: " + response.toString());
            }

            @Override
            public void onFailure(Call<ServerService> call, Throwable t) {
                Log.d(LOG_TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
