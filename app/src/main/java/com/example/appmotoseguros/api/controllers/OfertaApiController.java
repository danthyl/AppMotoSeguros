package com.example.appmotoseguros.api.controllers;

import android.content.Context;
import android.content.res.Resources;

import com.example.appmotoseguros.api.interfaces.OfertasApiInterface;
import com.example.appmotoseguros.api.request.CadastroRequest;
import com.example.appmotoseguros.model.Comprador;
import com.example.appmotoseguros.model.Ofertas;
import com.example.appmotoseguros.model.Veiculo;
import com.example.appmotoseguros.model.Vendedor;

import java.util.List;

import io.reactivex.Observable;

public class OfertaApiController extends RxApiController<OfertasApiInterface> {

    public OfertaApiController(Context context, String baseUrl, Resources resources) {
        super(OfertasApiInterface.class, context, baseUrl, resources);
    }

    public Observable<List<Ofertas>> obterOfertas(CadastroRequest request) {
        return apiInterface.obterOfertas(request);
    }
}
