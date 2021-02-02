package com.example.sistemadeseguridad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import Interfas.jsonEstadisticas;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Estadisticas extends AppCompatActivity {
    private TextView jsontex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        jsontex = (TextView) findViewById(R.id.texjason);
        getEstadisticas();
    }
    private  void getEstadisticas(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gtpreviene.researchmobile.co:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonEstadisticas jsonEstadisticas = retrofit.create(jsonEstadisticas.class);
        Call<Models.Estadisticas> call  = jsonEstadisticas.getEstadisticas();
        call.enqueue(new Callback<Models.Estadisticas>() {
            @Override
            public void onResponse(Call<Models.Estadisticas> call, Response<Models.Estadisticas> response) {
                if (!response.isSuccessful()){
                    jsontex.setText("codigo: "+ response.code());
                    return;
                }
                Models.Estadisticas Lisp = response.body();

                String content = "";
                content+="lastUpdate: " + Lisp.getLastUpdate() + "\n";
                content += "country: " + Lisp.getCountry() + "\n";
                content += "confirmed: " + Lisp.getConfirmed() + "\n";
                content += "deaths: " + Lisp.getDeaths() + "\n";
                content += "recovered: " + Lisp.getRecovered() + "\n";
                content += "enable: " + Lisp.getEnable() + "\n";
                jsontex.append(content);
            }

            @Override
            public void onFailure(Call<Models.Estadisticas> call, Throwable t) {
                jsontex.setText(t.getMessage());

            }
        });


    }
}