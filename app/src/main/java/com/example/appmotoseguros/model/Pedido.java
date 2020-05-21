package com.example.appmotoseguros.model;

import java.util.List;

public class Pedido {

    private String CpfCnpjComprador;
    private String numeroCelular;
    private Double total;
    //private String status = "pendente";
    //private int metodoPagamento;

    public Pedido(String cpfCnpjComprador, String numeroCelular, Double total, String observacao) {
        CpfCnpjComprador = cpfCnpjComprador;
        this.numeroCelular = numeroCelular;
        this.total = total;
    }

    public String getCpfCnpjComprador() {
        return CpfCnpjComprador;
    }

    public void setCpfCnpjComprador(String cpfCnpjComprador) {
        CpfCnpjComprador = cpfCnpjComprador;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
