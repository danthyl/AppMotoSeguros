package com.example.appmotoseguros.api.interfaces;

import com.example.appmotoseguros.api.response.LoginResponse;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApiInterface {

    @POST("token")
    Observable<LoginResponse> usuarioLogin(@Body RequestBody body);
}
