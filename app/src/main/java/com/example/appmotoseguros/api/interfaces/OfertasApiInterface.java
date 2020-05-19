package com.example.appmotoseguros.api.interfaces;

import com.example.appmotoseguros.model.Cadastro;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface OfertasApiInterface {

    @Headers("Content-Type:application/json; charset-8")
    @GET("SolicitacaoOferta/Obter")
    Call<Cadastro> ObterOferta();
}
