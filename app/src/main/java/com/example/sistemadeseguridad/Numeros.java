package com.example.sistemadeseguridad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sistemadeseguridad.adaptadores.NumerosAdaptador;

import Interfas.jsonNumeros;
import Models.Numero;
import Models.Respuesta;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Numeros extends AppCompatActivity {
    private TextView tnumero;
    private RecyclerView recycler;
    private ImageView ImagenNumeros, imagenNumeros2, getImagenNumeros3;
    private static final String URL_INTERNET = "http://gtpreviene.researchmobile.co:3000/uploads/jsdi65hkgz2swiel_mintrab.png";
    private Object Context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);
        recycler = (RecyclerView) findViewById(R.id.Num);
        ImagenNumeros = (ImageView) findViewById(R.id.imagen1);
        //imagenNumeros2 = (ImageView) findViewById();
        recycler.setLayoutManager(new LinearLayoutManager(this));



       //0 tnumero = (TextView) findViewById(R.id.texnumero);

        getNumeros();

    }

    private  void getNumeros(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gtpreviene.researchmobile.co:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonNumeros jsonNumeros = retrofit.create(jsonNumeros.class);
        Call<Respuesta> call =jsonNumeros.getNumeros();
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                if(!response.isSuccessful()){
                    tnumero.setText("codigo:"+ response.code());
                    return;
                }
                Respuesta lisn = response.body();
                NumerosAdaptador adaptador = new NumerosAdaptador(lisn.getData(), Numeros.this);
                recycler.setAdapter(adaptador);




            }


            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                tnumero.setText(t.getMessage());

            }
        });


    }




}