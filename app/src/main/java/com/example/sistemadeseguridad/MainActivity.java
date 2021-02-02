package com.example.sistemadeseguridad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button comenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comenzar = findViewById(R.id.buttoncomenzar);

    }
    public  void com (View view){
        Intent com = new Intent(this, Opciones.class);
        startActivity(com);
    }

}