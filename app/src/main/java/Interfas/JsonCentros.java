package Interfas;

import com.example.sistemadeseguridad.Centros;

import java.util.List;

import Models.Centro;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonCentros {
    @GET("centres")
    Call<List<Centro>> getCentros();
}
