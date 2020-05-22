package com.example.appmotoseguros.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Vendedor implements Serializable {

    @Expose
    @SerializedName("cpfCnpjVendedor")
    private String cpfCnpjVendedor;

    @Expose
    @SerializedName("numeroCelularVendedor")
    private String numeroCelularVendedor;

    @Expose
    @SerializedName("idloja")
    private String idloja;

    public String getCpfCnpjVendedor() {
        return cpfCnpjVendedor;
    }

    public void setCpfCnpjVendedor(String cpfCnpjVendedor) {
        this.cpfCnpjVendedor = cpfCnpjVendedor;
    }

    public String getNumeroCelularVendedor() {
        return numeroCelularVendedor;
    }

    public void setNumeroCelularVendedor(String numeroCelularVendedor) {
        this.numeroCelularVendedor = numeroCelularVendedor;
    }

    public String getIdloja() {
        return idloja;
    }

    public void setIdloja(String idloja) {
        this.idloja = idloja;
    }
}
