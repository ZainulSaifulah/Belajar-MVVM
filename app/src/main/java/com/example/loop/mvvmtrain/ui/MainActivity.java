package com.example.loop.mvvmtrain.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.loop.mvvmtrain.R;
import com.example.loop.mvvmtrain.data.Berita;
import com.example.loop.mvvmtrain.ui.berita.BeritaAdapter;
import com.example.loop.mvvmtrain.ui.berita.BeritaFragment;
import com.example.loop.mvvmtrain.ui.berita.BeritaViewModel;
import com.example.loop.mvvmtrain.ui.berita.BeritaViewModelFactory;
import com.example.loop.mvvmtrain.utilities.InjectorUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.e(MainActivity.class.getName(), "oncreate");
        if(savedInstanceState == null){
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.main_container, new BeritaFragment())
                    .commit();
        }

    }
}
