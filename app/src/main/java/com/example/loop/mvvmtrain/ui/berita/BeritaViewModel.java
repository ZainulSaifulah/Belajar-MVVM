package com.example.loop.mvvmtrain.ui.berita;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.loop.mvvmtrain.data.Berita;
import com.example.loop.mvvmtrain.data.NotesRepository;

import java.util.List;

public class BeritaViewModel extends ViewModel {
    private final LiveData<List<Berita>> listBerita;
    private final NotesRepository notesRepository;

    public BeritaViewModel(NotesRepository notesRepository){
        this.notesRepository = notesRepository;
        listBerita = notesRepository.getListBerita();
    }

    public LiveData<List<Berita>> getListBerita(){
        Log.e(BeritaViewModel.class.getName(), "viewmodel call" );
        return listBerita;
    }
}
