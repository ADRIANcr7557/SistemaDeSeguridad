package com.example.sistemadeseguridad.adaptadores;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemadeseguridad.R;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import Models.Numero;

public class NumerosAdaptador extends RecyclerView.Adapter<NumerosAdaptador.NumerosHolder> {
    private List<Numero> numeroList;
    private Context context;



    public NumerosAdaptador(List<Numero> numeroList, Context context) {
        this.numeroList = numeroList;
       // this.context = context;
    }


    @NonNull
    @Override
    public NumerosAdaptador.NumerosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_numero,null,false);
        context = parent.getContext();


        return new NumerosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumerosAdaptador.NumerosHolder holder, int position) {
        holder.asignarNumeros(numeroList.get(position));


       // holder.texNum.setText(numeroList.get(position).getPhone());
       //Picasso.Builder builder = new Picasso.Builder(context);
        //builder.downloader(new OkHttpDownloader(context));
        //builder.build().load(numeroList.get(position).getIcon())
          //      .placeholder(R.drawable.ic_launcher_background)
            //    .error(R.drawable.ic_launcher_background)
              //  .into(holder.imgNum);



    }

    @Override
    public int getItemCount() {
        return numeroList.size();
    }

    public class NumerosHolder extends RecyclerView.ViewHolder {
        TextView texNum;
        TextView texNom;
        ImageView imagen;
        ImageView imag2;
        private ImageView imgNum;



        public NumerosHolder(@NonNull View itemView) {

            super(itemView);
            imagen = itemView.findViewById(R.id.imagen1);
            //imag2 = itemView.findViewById(R.id.imagen2);

            //imagen2 = itemView.findViewById(R.id.Imagen2);

            texNum = itemView.findViewById(R.id.textitulo);
            texNom = itemView.findViewById(R.id.texnumero);



        }

        public void asignarNumeros(Numero numero) {
            texNum.setText(numero.title);
            texNom.setText(numero.phone);
            Picasso.with(context).load(numero.icon).into(imagen);


           // Picasso.with(context).load(URL_INTERNET2).into(imagen2);
            //Picasso.with(context).load(URL_INTERNET3).into(imagen);
        }
    }
}
