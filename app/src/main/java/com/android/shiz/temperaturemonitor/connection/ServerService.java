package com.android.shiz.temperaturemonitor.connection;

import com.google.gson.JsonObject;

import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by OldMan on 20.02.2016.
 */
public interface  ServerService {
    // ApiService.java
    @POST("/data")
    public Call<ServerService> sendDegree(
            @Query("dev") String dev, @Query("value") String value);
}
