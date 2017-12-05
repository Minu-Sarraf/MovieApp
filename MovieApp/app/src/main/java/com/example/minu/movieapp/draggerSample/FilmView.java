package com.example.minu.movieapp.draggerSample;

import com.example.minu.movieapp.model.MoviePopular;

import java.util.List;



public interface FilmView {
    void showLoading();

    void hideLoading();

    void showFilmz(List<MoviePopular> filmzItemList);

    void showErrorMessage();

   // void launchFoodDetail(FoodzItem foodzItem);
}
