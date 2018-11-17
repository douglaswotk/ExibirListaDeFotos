package exibirlistadefotos.douglas.com.exibirlistadefotos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServidorTesteService {

    @GET("photos")
    Call<List<Foto>> getFotos();


}
