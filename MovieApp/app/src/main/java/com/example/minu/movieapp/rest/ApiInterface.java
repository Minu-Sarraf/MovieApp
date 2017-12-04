package com.example.minu.movieapp.rest;

import com.example.minu.movieapp.model.CreditModel;
import com.example.minu.movieapp.model.MoviesResponse;
import com.example.minu.movieapp.model.VideoModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/popular")
    Call<MoviesResponse>getPopularMovies(@Query("api_key") String cb);

    @GET("movie/{category}")
    Call<MoviesResponse>getNowPlayingMovies(@Path("category") String category,@Query("api_key") String cb);


    //https://api.themoviedb.org/3/movie/346364/credits?api_key=97282286fc521068ca0ba0d1463d4062
    @GET("movie/{id}/credits")
    Call<CreditModel>getCredit(@Path("id") String itemId,@Query("api_key") String cb);

    //https://api.themoviedb.org/3/movie/1999/videos?api_key=97282286fc521068ca0ba0d1463d4062&language=en-US
    @GET("movie/{id}/videos")
    Call<VideoModel>getVideos(@Path("id") int itemId, @Query("api_key") String cb);

}

