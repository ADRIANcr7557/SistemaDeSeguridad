package com.example.sistemadeseguridad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Opciones extends AppCompatActivity {
    private Button estadisticas;
    private Button Numeros;
    private Button centros;
    private Button Noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        estadisticas = findViewById(R.id.butestadistica);
        Numeros = findViewById(R.id.butnumeros);
        centros = findViewById(R.id.butcentros);
        Noticias = findViewById(R.id.butnoticias);
    }

    public void esta (View view){
        Intent esta = new Intent(this,Estadisticas.class);
        startActivity(esta);
    }
    public  void num (View view){
        Intent num = new Intent(this,Numeros.class);
        startActivity(num);
    }
    public void atencion (View view){
        Intent atencion = new Intent(this, MapaCentrosGua.class);
        startActivity(atencion);
    }
    public void not (View view){
        Intent not = new Intent(this,Noticias.class);
        startActivity(not);
    }
}