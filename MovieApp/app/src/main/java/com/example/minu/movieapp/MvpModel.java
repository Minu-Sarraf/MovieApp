package com.example.minu.movieapp;

import android.util.Log;

import com.example.minu.movieapp.adapter.MoviesAdapter;
import com.example.minu.movieapp.model.MoviesResponse;
import com.example.minu.movieapp.rest.ApiInterface;
import com.example.minu.movieapp.rest.ApiList;

import javax.sql.DataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by minu on 10/30/2017.
 */

public class MvpModel extends DataSource1 {


    @Override
    public void getPhotos(String cat,final GetPhotosCallback callback) {
        ApiInterface apiService = ApiList.getClient().create(ApiInterface.class);
        Call<MoviesResponse> call = apiService.getNowPlayingMovies(cat, ApiList.API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                Log.e("response", response.body().getResults() + "");
                callback.onSuccess(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
            }
        });
    }

}
