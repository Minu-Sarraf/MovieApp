package com.example.minu.movieapp.dragger;

import com.example.minu.movieapp.model.MoviePopular;

import java.util.List;



public interface FoodzView {
    void showLoading();

    void hideLoading();

    void showFoodz(List<MoviePopular> foodzItemList);

    void showErrorMessage();

   // void launchFoodDetail(FoodzItem foodzItem);
}
