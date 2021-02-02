package Interfas;

import java.util.List;

import Models.Noticia;
import retrofit2.Call;
import retrofit2.http.GET;

public interface jsonNoticias {
    @GET("news")
    Call<List<Noticia>> getNoticia();
}
