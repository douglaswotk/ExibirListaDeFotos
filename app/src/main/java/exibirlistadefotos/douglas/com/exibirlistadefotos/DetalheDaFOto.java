package exibirlistadefotos.douglas.com.exibirlistadefotos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

public class DetalheDaFOto extends AppCompatActivity {
    public static final String KEY_INTENT = "KEY_FOTO";
    private SimpleDraweeView fotoView;
    private TextView tituloView;
    private Foto foto;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhe_fotos);

        fotoView = findViewById(R.id.imagem);
        tituloView = findViewById(R.id.titulo);

        foto = (Foto) getIntent().getExtras().getSerializable(KEY_INTENT);

        fotoView.setImageURI(foto.getUrl());
        tituloView.setText(foto.getTitle());
        getSupportActionBar().setTitle("Foto");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalhe_foto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deletar:
                setResult( 10,getIntent());
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
