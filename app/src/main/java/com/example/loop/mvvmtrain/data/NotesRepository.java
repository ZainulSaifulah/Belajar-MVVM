package com.example.loop.mvvmtrain.data;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.example.loop.mvvmtrain.data.api.BeritaDataSource;

import java.util.List;

public class NotesRepository {
    private static final Object LOCK = new Object();
    private static volatile NotesRepository sInstance;
    private final BeritaDataSource beritaDataSource;

    public static NotesRepository getInstance(){
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new NotesRepository();
                }
            }
        }
        return sInstance;
    }

    public NotesRepository(){
        beritaDataSource = new BeritaDataSource();
    }

    public LiveData<List<Berita>> getListBerita(){
        Log.e(NotesRepository.class.getName(), "repo call" );
        return beritaDataSource.getListBerita();
    }


}
