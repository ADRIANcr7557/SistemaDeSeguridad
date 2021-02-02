package com.example.sistemadeseguridad.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemadeseguridad.R;

import java.util.List;

import Models.Noticia;

public class NoticiasAdaptador extends RecyclerView.Adapter<NoticiasAdaptador.NoticasHolder> {
    private List<Noticia> lisNoticias;

    public NoticiasAdaptador(List<Noticia> lisNoticias) {
        this.lisNoticias = lisNoticias;
    }

    @NonNull
    @Override
    public NoticasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_noticias,parent, false);
        return new NoticasHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticasHolder holder, int position) {
        holder.asignarNotica(lisNoticias.get(position));

    }

    @Override
    public int getItemCount() {
        return lisNoticias.size();
    }

    public class NoticasHolder extends RecyclerView.ViewHolder {
        TextView dato1;
        TextView dato2;
        public NoticasHolder(@NonNull View itemView) {
            super(itemView);
            dato1 = itemView.findViewById(R.id.texNot);
            dato2 = itemView.findViewById(R.id.texDetalle);

        }

        public void asignarNotica(Noticia noticia) {
            dato1.setText(noticia.title);
            dato2.setText(noticia.detail);
        }
    }
}
