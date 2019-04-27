package com.example.loop.mvvmtrain.ui.berita;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.loop.mvvmtrain.data.NotesRepository;

public class BeritaViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final NotesRepository notesRepository;

    public BeritaViewModelFactory(NotesRepository notesRepository){
        this.notesRepository = notesRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new BeritaViewModel(notesRepository);
    }
}
