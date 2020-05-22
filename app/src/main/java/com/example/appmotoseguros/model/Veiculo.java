package com.example.appmotoseguros.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Veiculo implements Serializable {

    @Expose
    @SerializedName("comprovanteKilometragem")
    private String comprovanteKilometragem;

    @Expose
    @SerializedName("kilometragem")
    private String kilometragem;

    @Expose
    @SerializedName("placa")
    private String placa;

    @Expose
    @SerializedName("renavan")
    private String renavan;

    @Expose
    @SerializedName("numeroChassi")
    private String numeroChassi;

    public String getComprovanteKilometragem() {
        return comprovanteKilometragem;
    }

    public void setComprovanteKilometragem(String comprovanteKilometragem) {
        this.comprovanteKilometragem = comprovanteKilometragem;
    }

    public String getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(String kilometragem) {
        this.kilometragem = kilometragem;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavan() {
        return renavan;
    }

    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public String getNumeroChassi() {
        return numeroChassi;
    }

    public void setNumeroChassi(String numeroChassi) {
        this.numeroChassi = numeroChassi;
    }
}
