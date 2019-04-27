package com.example.loop.mvvmtrain.data.api;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.loop.mvvmtrain.data.Berita;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeritaDataSource {

    public LiveData<List<Berita>> getListBerita(){
        final MutableLiveData<List<Berita>> listMutableLiveData = new MutableLiveData<>();
        RetrofitService.getInstance().getListBerita().enqueue(new Callback<List<Berita>>() {
            @Override
            public void onResponse(Call<List<Berita>> call, Response<List<Berita>> response) {
                Log.e(BeritaDataSource.class.getName(), "datasource call" );
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Berita>> call, Throwable t) {
                listMutableLiveData.setValue(null);
            }
        });
        return listMutableLiveData;
    }
}
