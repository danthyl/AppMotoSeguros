package com.example.appmotoseguros.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmotoseguros.R;
import com.example.appmotoseguros.model.Ofertas;

import java.util.ArrayList;
import java.util.List;

public class AdapterOfertas extends RecyclerView.Adapter<AdapterOfertas.MyViewHolder> {

    private Context context;
    private List<Ofertas> listaOfertas;

    public AdapterOfertas(Context context) {
        this.context = context;
        this.listaOfertas = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_ofertas, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Ofertas ofertas = listaOfertas.get( position );
        holder.nome.setText(ofertas.getNome());
        holder.descricao.setText(ofertas.getDescricao());
        holder.preco.setText((CharSequence) ofertas.getPreco());
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

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        TextView descricao;
        TextView preco;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textNomeOferta);
            descricao = itemView.findViewById(R.id.textDescricaoOferta);
            preco = itemView.findViewById(R.id.textPrecoOferta);


        }
    }

}
