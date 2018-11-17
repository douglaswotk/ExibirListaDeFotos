package exibirlistadefotos.douglas.com.exibirlistadefotos;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import static exibirlistadefotos.douglas.com.exibirlistadefotos.R.id.item_geral;

public class FotosAdapter extends RecyclerView.Adapter<FotosAdapter.FotosViewHolder> {

    private List<Foto> fotos = new ArrayList<>();
    private ClickCallBack clickCallBack;

    public FotosAdapter(ClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }


    public void updateFotos(List<Foto> novasfotos) {
        fotos = novasfotos;
        notifyDataSetChanged();

    }

    public void deletaFoto(Foto foto){
        fotos.remove(foto);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public FotosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new FotosViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_foto, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FotosViewHolder fotosViewHolder, int position) {
        final Foto foto = fotos.get(position);
        fotosViewHolder.foto.setImageURI(foto.getThumbnailUrl());
        fotosViewHolder.titulo.setText(foto.getTitle());
        fotosViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCallBack.clickFoto(foto);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public interface ClickCallBack {

        void clickFoto(Foto foto);

    }

    public static class FotosViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView foto;
        private TextView titulo;
        private LinearLayout linearLayout;

        public FotosViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.imagem);
            titulo = itemView.findViewById(R.id.titulo);
            linearLayout = itemView.findViewById(R.id.item_geral);
        }
    }
}
