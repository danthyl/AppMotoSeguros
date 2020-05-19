package com.example.appmotoseguros.api.controllers;

import android.content.Context;
import android.content.res.Resources;

import com.example.appmotoseguros.api.interfaces.OperacaoApiInterface;

public class OperacaoApiController extends RxApiController<OperacaoApiInterface> {

    protected OperacaoApiController(Context context, String baseUrl, Resources resources) {
        super(OperacaoApiInterface.class, context, baseUrl, resources);
    }
}
