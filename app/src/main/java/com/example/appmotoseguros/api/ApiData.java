package com.example.appmotoseguros.api;

import com.example.appmotoseguros.model.Login;
import com.example.appmotoseguros.model.Cadastro;
import com.example.appmotoseguros.model.Operacao;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiData {

    @POST("token")
    @FormUrlEncoded
    Call<Login> usuarioLogin(
            @Field("username") String username,
            @Field("password") String password,
            @Field("grant_type") String pass
    );

    @Headers("Content-Type:application/json; charset-8")
    @POST("Operacao/Obter")
            Call<Operacao> ObterOperacao(
                    String geolocalizacao, String  marca, String modelo, String cnpjcliente, String numeroSerial

    );

    @Headers("Content-Type:application/json; charset-8")
    @GET("SolicitacaoOferta/Obter")
    Call<Cadastro> ObterOferta(
    );


}
