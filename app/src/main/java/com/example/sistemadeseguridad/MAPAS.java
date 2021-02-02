package com.example.sistemadeseguridad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.net.Uri;
import android.os.Bundle;

public class MAPAS extends AppCompatActivity implements FragmentMapa.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_a_p_a_s);
        Fragment fragmento = new FragmentMapa();
        getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor,fragmento).commit();
    }


    }



