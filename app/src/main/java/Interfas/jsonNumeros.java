package Interfas;

import java.util.List;

import Models.Numero;
import Models.Respuesta;
import retrofit2.Call;
import retrofit2.http.GET;

public interface jsonNumeros {
    @GET("api/information")
    Call<Respuesta> getNumeros();
}
