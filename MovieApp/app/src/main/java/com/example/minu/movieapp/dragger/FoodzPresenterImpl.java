package com.example.minu.movieapp.dragger;

import android.content.Context;

import com.example.minu.movieapp.adapter.MoviesAdapter;
import com.example.minu.movieapp.model.MoviePopular;
import com.example.minu.movieapp.model.MoviesResponse;
import com.example.minu.movieapp.rest.ApiInterface;
import com.example.minu.movieapp.rest.ApiList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



class FoodzPresenterImpl implements FoodzPresenter {
    private FoodzView view;
    List<MoviePopular> movies;
    @Inject
    ApiInterface usdaApi;


    public FoodzPresenterImpl(Context context) {
        ((DeezFoodApplication) context).getAppComponent().inject(this);
    }

    @Override
    public void setView(FoodzView view) {
        this.view = view;
    }

    @Override
    public void getFoodz() {
        view.showLoading();

        usdaApi.getPopularMovies(ApiList.API_KEY).enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {

                if (response.code() != 200) {

                    view.showErrorMessage();

                } else {

                    movies = response.body().getResults();
                    view.showFoodz(movies);
                }

                view.hideLoading();
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                view.showErrorMessage();
                view.hideLoading();
            }
        });
    }

}
