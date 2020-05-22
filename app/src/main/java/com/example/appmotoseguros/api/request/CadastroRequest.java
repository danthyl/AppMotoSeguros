package com.example.appmotoseguros.api.request;

import com.example.appmotoseguros.model.Comprador;
import com.example.appmotoseguros.model.Veiculo;
import com.example.appmotoseguros.model.Vendedor;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CadastroRequest {

    @Expose
    @SerializedName("comprador")
    private Comprador comprador;

    @Expose
    @SerializedName("veiculo")
    private Veiculo veiculo;

    @Expose
    @SerializedName("vendedor")
    private Vendedor vendedor;

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
