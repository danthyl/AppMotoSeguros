package com.example.appmotoseguros.api.interfaces;

import com.example.appmotoseguros.model.Ofertas;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface OfertasApiInterface {

    @Headers("Content-Type:application/json")
    @GET("SolicitacaoOferta/Obter")
    Observable<List<Ofertas>> obterOfertas();
}
