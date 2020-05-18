package com.example.appmotoseguros.model;

public class Operacao {

    private String geolocalizacao;
    private String marca;
    private String modelo;
    private String cnpjcliente;
    private String numeroSerial;


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