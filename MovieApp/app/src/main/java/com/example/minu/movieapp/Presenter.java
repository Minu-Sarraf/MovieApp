package com.example.minu.movieapp;

import android.content.Context;
import android.opengl.Visibility;
import android.util.Log;

import com.example.minu.movieapp.adapter.MoviesAdapter;
import com.example.minu.movieapp.model.MoviePopular;

import java.util.List;

/**
 * Created by minu on 10/31/2017.
 */

public class Presenter implements MovieContract.Presenter {
    MvpModel mp;
    List<MoviePopular> movies;
    MoviesAdapter mAdapter;
    String cat;
    MovieContract.View view;

    public Presenter(MovieContract.View view, MvpModel mvpModel,String category) {
        this.view = view;
        this.mp = mvpModel;
        this.cat = category;
    }

    @Override
    public void getPhotos(final Context context) {
        Log.e("presenter", view + "mm");
        if (view == null) {
            return;
        }
        view.setProgressBar(true);
        mp.getPhotos(cat, new DataSource1.GetPhotosCallback() {
            @Override
            public void onSuccess(List<MoviePopular> photos) {

                Log.e("success", photos.get(0).getOverview());
                movies = photos;
                view.showPhotos(photos, cat, context);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("presenter", throwable.getCause() + throwable.getMessage());
                view.setProgressBar(false);
            }

            @Override
            public void tabPosition(int position) {

            }

            @Override
            public void onNetworkFailure() {
                // Toast.makeText(c, "Network Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
