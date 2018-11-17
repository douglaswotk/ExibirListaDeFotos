package exibirlistadefotos.douglas.com.exibirlistadefotos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static exibirlistadefotos.douglas.com.exibirlistadefotos.DetalheDaFOto.KEY_INTENT;

public class ListaDeFotos extends AppCompatActivity {

    private String TAG = ListaDeFotos.class.getSimpleName();
    private RecyclerView recyclerView;
    private FotosAdapter fotosAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_fotos);
        recyclerView = findViewById(R.id.listaDeFotos);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(gridLayoutManager);
        fotosAdapter = new FotosAdapter(new FotosAdapter.ClickCallBack() {
            @Override
            public void clickFoto(Foto foto) {
                Intent intent = new Intent(ListaDeFotos.this, DetalheDaFOto.class);
                intent.putExtra(KEY_INTENT, foto);

                startActivityForResult(intent, 1);
            }
        });
        recyclerView.setAdapter(fotosAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServidorTesteService servidorTesteService = retrofit.create(ServidorTesteService.class);

        servidorTesteService.getFotos().enqueue(new Callback<List<Foto>>() {
            @Override
            public void onResponse(Call<List<Foto>> call, Response<List<Foto>> response) {
                Log.d(TAG, "onResponse" + response.toString());
                fotosAdapter.updateFotos(response.body());
            }

            @Override
            public void onFailure(Call<List<Foto>> call, Throwable t) {
                Log.d(TAG, "onFalilure", t);
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 10 && data != null) {
            fotosAdapter.deletaFoto((Foto) data.getExtras().getSerializable(KEY_INTENT));

        }
    }
}

