package com.example.lab12;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.nombre.setText(lista.get(i).getNombre());
        holder.descripcion.setText(lista.get(i).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
       private TextView nombre,descripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=(TextView) itemView.findViewById(R.id.titulo);
            descripcion=(TextView) itemView.findViewById(R.id.descripcion);
        }
    }
    public List<Modelo> lista;
    public Adapter(List<Modelo>lista){this.lista=lista;}
}
