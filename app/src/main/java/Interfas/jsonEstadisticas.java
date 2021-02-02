package Interfas;

import Models.Estadisticas;
import retrofit2.Call;
import retrofit2.http.GET;

public interface jsonEstadisticas {
    @GET("api/covid")
    Call<Estadisticas> getEstadisticas();

}
