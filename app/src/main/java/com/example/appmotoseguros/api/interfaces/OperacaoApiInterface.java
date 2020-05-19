package com.example.appmotoseguros.api.interfaces;

import com.example.appmotoseguros.model.Operacao;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface OperacaoApiInterface {

    @Headers("Content-Type:application/json; charset-8")
    @POST("Operacao/Obter")
    Call<Operacao> ObterOperacao(
            String geolocalizacao, String  marca, String modelo, String cnpjcliente, String numeroSerial

    );
}
