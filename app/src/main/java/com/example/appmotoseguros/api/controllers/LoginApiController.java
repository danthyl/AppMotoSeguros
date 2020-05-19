package com.example.appmotoseguros.api.controllers;

import android.content.Context;
import android.content.res.Resources;

import com.example.appmotoseguros.api.interfaces.LoginApiInterface;
import com.example.appmotoseguros.api.request.LoginRequest;
import com.example.appmotoseguros.api.response.LoginResponse;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class LoginApiController extends RxApiController<LoginApiInterface> {

    public LoginApiController(Context context, String baseUrl, Resources resources) {
        super(LoginApiInterface.class, context, baseUrl, resources);
    }

    public Observable<LoginResponse> usuarioLogin(String username, String password){
        LoginRequest request = new LoginRequest();
        request.setUsername(username);
        request.setPassword(password);
        request.setGrantType("password");
        RequestBody body =
                RequestBody.create(MediaType.parse("text/plain"), request.toString());
        return apiInterface.usuarioLogin(body);
    }
}
