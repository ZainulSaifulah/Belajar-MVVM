package com.example.loop.mvvmtrain.data.api;

import com.example.loop.mvvmtrain.data.Berita;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NotesService {
    @GET("/api-students/get-news")
    Call<List<Berita>> listBerita();
}
