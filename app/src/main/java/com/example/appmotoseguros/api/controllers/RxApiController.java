package com.example.appmotoseguros.api.controllers;

import android.content.Context;
import android.content.res.Resources;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.net.ProtocolException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RxApiController<T> extends ApiController<T> {

    protected RxApiController(Class<T> apiInterfaceClass, Context context, String baseUrl, Resources resources) {
        super(apiInterfaceClass, context, baseUrl, resources);
    }

    @Override
    protected void initializeRetrofit(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addNetworkInterceptor(chain -> {
            Response response;
            try {
                response = chain.proceed(chain.request());
            } catch (ProtocolException e) {
                response = new Response.Builder()
                        .request(chain.request())
                        .code(204)
                        .addHeader("Content-Type", "application/json")
                        .protocol(Protocol.HTTP_1_1)
                        .message("normal delete, move along")
                        .body(new ResponseBody() {
                            @Nullable
                            @Override
                            public MediaType contentType() {
                                return null;
                            }

                            @Override
                            public long contentLength() {
                                return 0;
                            }

                            @Override
                            public BufferedSource source() {
                                return null;
                            }
                        })
                        .build();
            }
            return response;
        });

        GsonBuilder gsonBuilder = new GsonBuilder()
                .disableHtmlEscaping();

        gsonBuilder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()));

        Gson gson = gsonBuilder.create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }
}

