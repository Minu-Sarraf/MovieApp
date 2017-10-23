package com.example.minu.movieapp.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by minu on 10/5/2017.
 */

public class ApiList {


    //https://api.themoviedb.org/3/movie/550?api_key=97282286fc521068ca0ba0d1463d4062
    //https://api.themoviedb.org/3/movie/now_playing?api_key=97282286fc521068ca0ba0d1463d4062&language=en-US&page=1
    public final static String API_KEY = "97282286fc521068ca0ba0d1463d4062";
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;
    public static final String TMDB_IMAGE_PATH = "http://image.tmdb.org/t/p/w500";
    String url = "https://api.themoviedb.org/4/account/{account_id}/lists?page=1";
    String movieList = "/discover/movie?primary_release_date.gte=2014-09-15&primary_release_date.lte=2014-10-22";
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
