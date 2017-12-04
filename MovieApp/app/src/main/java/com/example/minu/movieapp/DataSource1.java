package com.example.minu.movieapp;

import com.example.minu.movieapp.model.MoviePopular;
import com.example.minu.movieapp.model.MoviesResponse;

import java.util.List;

/**
 * Created by minu on 10/30/2017.
 */
public abstract class DataSource1 {

    public abstract void getPhotos(String cat, GetPhotosCallback callback);

    public interface GetPhotosCallback {
        void onSuccess(List<MoviePopular> photos);

        void onFailure(Throwable throwable);

        void tabPosition(int position);

        void onNetworkFailure();

    }


}
