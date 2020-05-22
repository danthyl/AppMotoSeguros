package com.example.appmotoseguros.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Comprador implements Serializable {

    @Expose
    @SerializedName("cpfCnpj")
    private String cpfCnpj;

    @Expose
    @SerializedName("datanascimento")
    private String datanascimento;

    @Expose
    @SerializedName("sexo")
    private String sexo;

    @Expose
    @SerializedName("estadoCivil")
    private String estadoCivil;

    @Expose
    @SerializedName("endereco")
    private Endereco endereco;

    @Expose
    @SerializedName("numeroCelular")
    private String numeroCelular;

    @Expose
    @SerializedName("possuiOutroVeic")
    private String possuiOutroVeic;

    @Expose
    @SerializedName("tipoContratacao")
    private String tipoContratacao;

    @Expose
    @SerializedName("utilizacaoDut")
    private String utilizacaoDut;

    @Expose
    @SerializedName("tipoUtilizacao")
    private String tipoUtilizacao;

    @Expose
    @SerializedName("pergunta1")
    private String pergunta1;

    @Expose
    @SerializedName("pergunta2")
    private String pergunta2;

    @Expose
    @SerializedName("pergunta3")
    private String pergunta3;

    @Expose
    @SerializedName("principalCondutor")
    private PrincipalCondutor principalCondutor;

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
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

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getPossuiOutroVeic() {
        return possuiOutroVeic;
    }

    public void setPossuiOutroVeic(String possuiOutroVeic) {
        this.possuiOutroVeic = possuiOutroVeic;
    }

    public String getTipoContratacao() {
        return tipoContratacao;
    }

    public void setTipoContratacao(String tipoContratacao) {
        this.tipoContratacao = tipoContratacao;
    }

    public String getUtilizacaoDut() {
        return utilizacaoDut;
    }

    public void setUtilizacaoDut(String utilizacaoDut) {
        this.utilizacaoDut = utilizacaoDut;
    }

    public String getTipoUtilizacao() {
        return tipoUtilizacao;
    }

    public void setTipoUtilizacao(String tipoUtilizacao) {
        this.tipoUtilizacao = tipoUtilizacao;
    }

    public String getPergunta1() {
        return pergunta1;
    }

    public void setPergunta1(String pergunta1) {
        this.pergunta1 = pergunta1;
    }

    public String getPergunta2() {
        return pergunta2;
    }

    public void setPergunta2(String pergunta2) {
        this.pergunta2 = pergunta2;
    }

    public String getPergunta3() {
        return pergunta3;
    }

    public void setPergunta3(String pergunta3) {
        this.pergunta3 = pergunta3;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public PrincipalCondutor getPrincipalCondutor() {
        return principalCondutor;
    }

    public void setPrincipalCondutor(PrincipalCondutor principalCondutor) {
        this.principalCondutor = principalCondutor;
    }
}
