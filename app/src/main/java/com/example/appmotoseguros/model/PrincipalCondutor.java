package com.example.appmotoseguros.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PrincipalCondutor implements Serializable {

    @Expose
    @SerializedName("cpfCnpj")
    private String cpfCnpj;

    @Expose
    @SerializedName("nome")
    private String nome;

    @Expose
    @SerializedName("sexo")
    private String sexo;

    @Expose
    @SerializedName("estadoCivil")
    private String estadoCivil;

    @Expose
    @SerializedName("datanascimento")
    private String datanascimento;

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }
}
