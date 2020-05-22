package com.example.appmotoseguros.api.interfaces;

import com.example.appmotoseguros.api.request.CadastroRequest;
import com.example.appmotoseguros.model.Ofertas;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface OfertasApiInterface {

    @Headers("Content-Type: application/json; charset=utf-8")
    @POST("SolicitacaoOferta/Obter")
    Observable<List<Ofertas>> obterOfertas(@Body CadastroRequest request);
}
