package com.example.appmotoseguros.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmotoseguros.R;
import com.example.appmotoseguros.activities.ListaOfertasActivity;
import com.example.appmotoseguros.model.Ofertas;

import java.util.ArrayList;
import java.util.List;

public class AdapterOfertas extends RecyclerView.Adapter<AdapterOfertas.MyViewHolder> {

    private ListaOfertasActivity context;
    private List<Ofertas> listaOfertas;

    public List<Ofertas> selected;
    public float precoFinal;

    public AdapterOfertas(ListaOfertasActivity context) {
        this.context = context;
        this.listaOfertas = new ArrayList<>();
        this.selected = new ArrayList<>();
        precoFinal = 0.0f;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_ofertas, parent, false);
        return new MyViewHolder(itemLista);
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Ofertas ofertas = listaOfertas.get(position);
        holder.nome.setText(ofertas.getNome());
        holder.descricao.setText(ofertas.getDescricao());
        holder.preco.setText(ofertas.getPreco());

        holder.cbOferta.setOnCheckedChangeListener((buttonView, isChecked) -> {

            ofertas.setSelected(isChecked);

            if (ofertas.isSelected()) {
                selected.add(ofertas);
                precoFinal += Float.parseFloat(ofertas.getPreco().replaceAll("[^\\d.]", ""));
            } else {
                if (selected.contains(ofertas)) {
                    selected.remove(ofertas);
                    precoFinal -= Float.parseFloat(ofertas.getPreco().replaceAll("[^\\d.]", ""));
                }
            }

            atualizaItens();
        });
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void atualizaItens() {
        if (precoFinal <= 0.0f || selected.size() <= 0) {
            precoFinal = 0.0f;
        }

        context.textItensQtd.setText("ITENS QTD. " + selected.size() +
                " - R$" + String.format("%.2f", precoFinal));
    }

    @Override
    public int getItemCount() {
        return listaOfertas.size();
    }

    public void add(Ofertas r) {
        listaOfertas.add(r);
        notifyItemInserted(listaOfertas.size() - 1);
    }

    public void addAll(List<Ofertas> moveResults) {
        for (Ofertas result : moveResults) {
            result.setSelected(false);
            add(result);
        }
    }

    public void remove(Ofertas r) {
        int position = listaOfertas.indexOf(r);
        if (position > -1) {
            listaOfertas.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public Ofertas getItem(int position) {
        return listaOfertas.get(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nome;
        TextView descricao;
        TextView preco;
        CheckBox cbOferta;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textNomeOferta);
            descricao = itemView.findViewById(R.id.textDescricaoOferta);
            preco = itemView.findViewById(R.id.textPrecoOferta);
            cbOferta = itemView.findViewById(R.id.cb_oferta_select);


        }
    }

}
