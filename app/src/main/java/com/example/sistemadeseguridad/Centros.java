package com.example.sistemadeseguridad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import Interfas.JsonCentros;
import Models.Centro;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Centros extends AppCompatActivity {
    public TextView centroTex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centros);
        centroTex = (TextView) findViewById(R.id.texcentro);
        getCentros();
    }
    public void getCentros(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gtpreviene.researchmobile.co:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonCentros jsonCentros = retrofit.create(JsonCentros.class);
        Call<List<Centro>> call = jsonCentros.getCentros();
        call.enqueue(new Callback<List<Centro>>() {

            @Override
            public void onResponse(Call<List<Centro>> call, Response<List<Centro>> response) {
                if (!response.isSuccessful()){
                    centroTex.setText("codigo"+ response.code());
                    return;
                }
                List <Centro> lisC = response.body();
                for (Centro centro: lisC){
                    String content = "";
                    content+="id: " + centro.getId() + "\n";
                    content+="name: " + centro.getName() + "\n";
                    content+="description: " + centro.getDescription() + "\n";
                    content+="latitude: " + centro.getLatitude() + "\n";
                    content+="longitude: " + centro.getLongitude() + "\n";
                    content+="active: " + centro.getActive() + "\n";
                    centroTex.append(content);

                }

            }

            @Override
            public void onFailure(Call<List<Centro>> call, Throwable t) {
                centroTex.setText(t.getMessage());

            }
        });


    }
}