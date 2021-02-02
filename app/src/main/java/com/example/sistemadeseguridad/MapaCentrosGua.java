package com.example.sistemadeseguridad;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import Interfas.JsonCentros;
import Models.Centro;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapaCentrosGua extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_centros_gua);


        int stats = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if (stats == ConnectionResult.SUCCESS) {


            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        } else {
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(stats, (Activity) getApplicationContext(), 10);
            dialog.show();
        }
    }
    public void getCentros(GoogleMap googleMap){
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
                    //centroTex.setText("codigo"+ response.code());
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
                    mMap = googleMap;
                    final LatLng punto1 = new LatLng(centro.getLatitude(), centro.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(punto1).title(centro.getName()));

                    //centroTex.append(content);

                }

            }

            @Override
            public void onFailure(Call<List<Centro>> call, Throwable t) {
                //centroTex.setText(t.getMessage());

            }
        });


    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        //{
          //return;

        //}
        //mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        UiSettings  uiSettings = mMap.getUiSettings();

       // centers(googleMap);
        getCentros(googleMap);

    }
    public void centers(GoogleMap googleMap){
        mMap = googleMap;
        final LatLng punto1 = new LatLng(14.85757246,-90.13527419);
        final LatLng punto2 = new LatLng(14.89828198,-90.20930618);

        mMap.addMarker(new MarkerOptions().position(punto1).title("EL PROGRESO,GUASTATOYA"));
        mMap.addMarker(new MarkerOptions().position(punto2).title("EL PROGRESO,MORAZAN"));


    }




}


