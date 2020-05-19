package com.example.appmotoseguros.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Operacao {

    @Expose
    @SerializedName("geolocalizacao")
    private String geolocalizacao;

    @Expose
    @SerializedName("marca")
    private String marca;

    @Expose
    @SerializedName("modelo")
    private String modelo;

    @Expose
    @SerializedName("cnpjcliente")
    private String cnpjcliente;

    @Expose
    @SerializedName("numeroSerial")
    private String numeroSerial;

    public Operacao(){}

    public Operacao(String geolocalizacao, String marca, String modelo, String cnpjcliente, String numeroSerial) {
        this.geolocalizacao = geolocalizacao;
        this.marca = marca;
        this.modelo = modelo;
        this.cnpjcliente = cnpjcliente;
        this.numeroSerial = numeroSerial;
    }

    public String getGeolocalizacao() {
        return geolocalizacao;
    }

    public void setGeolocalizacao(String geolocalizacao) {
        this.geolocalizacao = geolocalizacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCnpjcliente() {
        return cnpjcliente;
    }

    public void setCnpjcliente(String cnpjcliente) {
        this.cnpjcliente = cnpjcliente;
    }

    public String getNumeroSerial() {
        return numeroSerial;
    }

    public void setNumeroSerial(String numeroSerial) {
        this.numeroSerial = numeroSerial;
    }
}