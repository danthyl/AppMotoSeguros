package com.example.appmotoseguros.api.interfaces;

import com.example.appmotoseguros.model.Operacao;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface OperacaoApiInterface {
    @Headers("Content-Type:application/json; charset-8")
    @POST("Operacao/Obter")
    Observable<Operacao> obterOperacao();
}
