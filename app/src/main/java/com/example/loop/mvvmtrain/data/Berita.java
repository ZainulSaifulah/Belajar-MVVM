package com.example.loop.mvvmtrain.data;

import com.google.gson.annotations.SerializedName;

public class Berita {
    @SerializedName("picture")
    private String imageUrl ;

    @SerializedName("title")
    private String judul ;

    @SerializedName("content")
    private String deskripsi ;

    @SerializedName("preview")
    private String preview ;

    @SerializedName("tag")
    private String tag ;

    @SerializedName("news_date")
    private String tanggal ;

    public Berita(String imageUrl, String judul, String deskripsi, String preview, String tag, String tanggal) {
        this.imageUrl = imageUrl;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.preview = preview;
        this.tag = tag;
        this.tanggal = tanggal;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getPreview() {
        return preview;
    }

    public String getTag() {
        return tag;
    }

    public String getTanggal() {
        return tanggal;
    }
}
