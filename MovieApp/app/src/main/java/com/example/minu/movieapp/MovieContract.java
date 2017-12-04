package com.example.minu.movieapp;

import android.content.Context;

import com.example.minu.movieapp.model.MoviePopular;

import java.util.List;

/**
 * Created by minu on 10/31/2017.
 */

public interface MovieContract {

    interface  View extends InterfaceClass{
        void showPhotos(List<MoviePopular>  photos,String cat, Context c);
    }
    interface Presenter  {

        void getPhotos(Context context);
    }
}
