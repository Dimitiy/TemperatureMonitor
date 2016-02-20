package com.android.shiz.temperaturemonitor.connection;

import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by OldMan on 20.02.2016.
 */
public class ServerService {


    // ApiService.java
    @FormUrlEncoded
    @POST("/api/set")
    public Call<ServerService> sendDegree(
            @Body Request request,
            Callback<JsonObject> cb) {

        return null;
    }
}
