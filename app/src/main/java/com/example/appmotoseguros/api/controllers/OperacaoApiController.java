package com.example.appmotoseguros.api.controllers;

import android.content.Context;
import android.content.res.Resources;

import com.example.appmotoseguros.api.interfaces.OperacaoApiInterface;
import com.example.appmotoseguros.api.session.SessionController;
import com.example.appmotoseguros.model.Operacao;

import io.reactivex.Observable;

public class OperacaoApiController extends RxApiController<OperacaoApiInterface> {

    protected OperacaoApiController(Context context, String baseUrl, Resources resources) {
        super(OperacaoApiInterface.class, context, baseUrl, resources);
    }

    public Observable<Operacao> obterOperacao() {
        String token = SessionController.getInstance().getToken();
        return apiInterface.obterOperacao();
    }
}
