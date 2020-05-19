package com.example.appmotoseguros.api.controllers;

import android.content.Context;
import android.content.res.Resources;

import com.example.appmotoseguros.api.interfaces.OfertasApiInterface;
import com.example.appmotoseguros.api.interfaces.OperacaoApiInterface;

public class OfertaApiController extends RxApiController<OfertasApiInterface> {

    protected OfertaApiController(Context context, String baseUrl, Resources resources) {
        super(OfertasApiInterface.class, context, baseUrl, resources);
    }
}
