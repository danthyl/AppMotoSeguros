package com.example.appmotoseguros.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmotoseguros.R;
import com.example.appmotoseguros.model.Ofertas;

import java.util.List;

public class AdapterOfertas extends RecyclerView.Adapter<AdapterOfertas.MyViewHolder> {

    private List<Ofertas> listaOfertas;

    public AdapterOfertas(List<Ofertas> ofertas) {
        this.listaOfertas = ofertas;

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
