package com.example.loop.mvvmtrain.ui.berita;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.loop.mvvmtrain.R;
import com.example.loop.mvvmtrain.data.Berita;
import com.example.loop.mvvmtrain.utilities.InjectorUtils;

import java.util.List;

public class BeritaFragment extends Fragment {

    private BeritaViewModel mViewModel;
    private RecyclerView recyclerView;
    private BeritaAdapter beritaAdapter;
    private View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.berita_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_berita);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        Log.e(BeritaFragment.class.getName(), "onChanged: " );
        beritaAdapter = new BeritaAdapter(getContext());

        recyclerView.setAdapter(beritaAdapter);

        BeritaViewModelFactory factory = InjectorUtils.provideBeritaViewModelFactory();
        mViewModel = ViewModelProviders.of(this, factory).get(BeritaViewModel.class);
        mViewModel.getListBerita().observe(this, new Observer<List<Berita>>() {
            @Override
            public void onChanged(@Nullable List<Berita> listBerita) {
                recyclerView.setAdapter(beritaAdapter);
                beritaAdapter.setData(listBerita);
            }
        });
    }



}
