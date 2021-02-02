package com.example.sistemadeseguridad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sistemadeseguridad.adaptadores.NoticiasAdaptador;

import java.util.ArrayList;
import java.util.List;

import Interfas.jsonNoticias;
import Models.Noticia;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class

Noticias extends AppCompatActivity {
    public TextView NotTex;
    RecyclerView recyvler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        recyvler = findViewById(R.id.recycleNot);
        recyvler.setLayoutManager(new LinearLayoutManager(this));
       //NotTex = (TextView) findViewById(R.id.texNoticias);

        getNoticia();
    }
    public void getNoticia(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gtpreviene.researchmobile.co:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonNoticias jsonNoticias = retrofit.create(jsonNoticias.class);
        Call<List<Noticia>> call = jsonNoticias.getNoticia();
        call.enqueue(new Callback<List<Noticia>>() {
            @Override
            public void onResponse(Call<List<Noticia>> call, Response<List<Noticia>> response) {
                if(!response.isSuccessful()){
                    NotTex.setText("codigo"+ response.code());
                    return;
                }
               List<Noticia > lisNot = response.body();
                for (Noticia noticia: lisNot){
                    String content = "";
                    content += "idedddddd:" + noticia.getId()+ "\n";
                    content += "image"+ noticia.getImage()+ "\n";
                    content += "titulo"+ noticia.getTitle() +"\n";
                    content += "detail"+ noticia.getDetail() + "\n"+ "\n" + "\n";

                    //NotTex.append(content);
                    NoticiasAdaptador adaptador  = new NoticiasAdaptador(lisNot);
                    recyvler.setAdapter(adaptador);

                }



            }

            @Override
            public void onFailure(Call<List<Noticia>> call, Throwable t) {
                NotTex.setText(t.getMessage());

            }
        });

    }


}