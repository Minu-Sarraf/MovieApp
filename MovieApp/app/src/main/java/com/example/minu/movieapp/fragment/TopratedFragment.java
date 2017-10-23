package com.example.minu.movieapp.fragment;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minu.movieapp.R;
import com.example.minu.movieapp.activity.DetailActivity;
import com.example.minu.movieapp.activity.MainActivity;
import com.example.minu.movieapp.adapter.MoviesAdapter;
import com.example.minu.movieapp.model.MoviePopular;
import com.example.minu.movieapp.model.MoviesResponse;
import com.example.minu.movieapp.rest.ApiInterface;
import com.example.minu.movieapp.rest.ApiList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.minu.movieapp.rest.ApiList.API_KEY;

/**
 * Created by minu on 10/22/2017.
 */

public class TopratedFragment extends Fragment {
    RecyclerView mRecyclerView;
    public static final String TMDB_IMAGE_PATH = "http://image.tmdb.org/t/p/w500";
    private MoviesAdapter mAdapter;
    List<MoviePopular> movies;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.top_rated_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mAdapter = new MoviesAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        ApiInterface apiService = ApiList.getClient().create(ApiInterface.class);
        //List<MoviePopular> movies = ((MainActivity)getActivity()).movies;


        Call<MoviesResponse> call = apiService.getTopRatedMovies(ApiList.API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                Log.e("response", response.body().getResults() + "");
                movies = response.body().getResults();
                mAdapter.setMovieList(movies);
                mAdapter.setCallback((MoviesAdapter.AdapterCallback) getActivity());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
            }
        });
        return view;
    }


}
