package com.example.loop.mvvmtrain.data.api;

import com.example.loop.mvvmtrain.data.Berita;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String BASE_URL = "http://notes.lpkia.ac.id";
    private NotesService notesService;
    private static final Object LOCK = new Object();
    private static volatile RetrofitService sInstance;

    public static RetrofitService getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new RetrofitService();
                }
            }
        }
        return sInstance;

    }


    public RetrofitService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        notesService = retrofit.create(NotesService.class);
    }

    public Call<List<Berita>> getListBerita() {
        return notesService.listBerita();
    }
}
