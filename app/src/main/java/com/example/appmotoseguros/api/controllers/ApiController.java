package com.example.appmotoseguros.api.controllers;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Toast;

import com.example.appmotoseguros.R;
import com.google.gson.JsonDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alemao13 on 02/04/2018.
 */

public abstract class ApiController<T> {

    protected T apiInterface;

    private Context context;

    protected Resources resources;

    protected Retrofit retrofit;

    protected String baseUrl;

    protected ApiController(final Class<T> apiInterfaceClass,
                            Context context,
                            String baseUrl,
                            Resources resources){
        this.context = context;
        this.resources = resources;
        this.baseUrl = baseUrl;
        initializeRetrofit();
        initializeApiInterface(apiInterfaceClass);
    }

    protected Context getContext() {
        return context;
    }

    protected void initializeApiInterface(final Class<T> apiInterfaceClass){
        apiInterface = retrofit.create(apiInterfaceClass);
    }

    protected String getBaseUrl(){
        return baseUrl;
    }

    protected void initializeRetrofit(){
        GsonBuilder gsonBuilder = new GsonBuilder()
                .disableHtmlEscaping();

        gsonBuilder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()));

        Gson gson = gsonBuilder.create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> Log.i("OkHttp", message));
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }

    public void displayGenericServerError(){
        Toast.makeText(getContext(), R.string.msg_server_error, Toast.LENGTH_SHORT).show();
    }

    public T getApiInterface() {
        return apiInterface;
    }

    public void setApiInterface(T apiInterface) {
        this.apiInterface = apiInterface;
    }

    public String generateAuthorizationHeaderFromToken(String token) {
        return token;
    }
}