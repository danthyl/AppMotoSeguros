package com.example.appmotoseguros.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class Ofertas implements Serializable {

    @Expose
    @SerializedName("id")
    private final String id;

    @Expose
    @SerializedName("nome")
    private final String nome;

    @Expose
    @SerializedName("descricao")
    private final String descricao;

    @Expose
    @SerializedName("cobertura")
    private final String cobertura;

    @Expose
    @SerializedName("preco")
    private final BigDecimal preco;

    @Expose
    @SerializedName("fipe")
    private final String fipe;

    public Ofertas(String id, String nome, String descricao, String cobertura, BigDecimal preco, String fipe) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cobertura = cobertura;
        this.preco = preco;
        this.fipe = fipe;
    }

    public String getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCobertura() { return cobertura; }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getFipe() {
        return fipe;
    }

}
