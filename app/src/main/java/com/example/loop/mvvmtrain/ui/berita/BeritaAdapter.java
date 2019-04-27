package com.example.loop.mvvmtrain.ui.berita;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.loop.mvvmtrain.R;
import com.example.loop.mvvmtrain.data.Berita;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaAdapterViewHolder> {
    private final Context context;
    private List<Berita> listBerita;

    public BeritaAdapter(@NonNull Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public BeritaAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.berita_item, viewGroup, false);
        return new BeritaAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BeritaAdapterViewHolder beritaAdapterViewHolder, int i) {
        Berita berita = listBerita.get(i);

        String imageBerita = "http://notes.lpkia.ac.id" + berita.getImageUrl();
        String judulBerita = berita.getJudul();
        String previewBerita = berita.getPreview();

        Log.e(BeritaAdapter.class.getName(), imageBerita);

        Glide.with(context).load(imageBerita).into(beritaAdapterViewHolder.gambarBerita);
        beritaAdapterViewHolder.judulBerita.setText(judulBerita);
        beritaAdapterViewHolder.previewBerita.setText(previewBerita);
    }

    @Override
    public int getItemCount() {
        if(listBerita == null) return 0;
        return listBerita.size();
    }

    public void setData(List<Berita> listBerita){
        this.listBerita = listBerita;
    }

    public class BeritaAdapterViewHolder extends RecyclerView.ViewHolder{
        private final ImageView gambarBerita;
        private final TextView judulBerita;
        private final TextView previewBerita;

        public BeritaAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            gambarBerita = itemView.findViewById(R.id.gambar_berita);
            judulBerita = itemView.findViewById(R.id.judul_berita);
            previewBerita = itemView.findViewById(R.id.preview_berita);
        }
    }
}
