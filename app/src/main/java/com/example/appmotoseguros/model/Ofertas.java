package com.example.appmotoseguros.model;

import java.math.BigDecimal;

public class Ofertas {

    private final String id;
    private final String nome;
    private final String descricao;
    private final String cobertura;
    private final BigDecimal preco;
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
