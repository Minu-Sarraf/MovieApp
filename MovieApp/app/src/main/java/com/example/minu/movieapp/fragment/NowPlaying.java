package com.example.minu.movieapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.minu.movieapp.DataSource1;
import com.example.minu.movieapp.MvpModel;
import com.example.minu.movieapp.R;
import com.example.minu.movieapp.activity.BindView;
import com.example.minu.movieapp.adapter.MoviesAdapter;
import com.example.minu.movieapp.model.MoviePopular;
import com.example.minu.movieapp.rest.ApiInterface;
import com.example.minu.movieapp.rest.ApiList;

import java.util.List;

/**
 * Created by minu on 10/22/2017.
 */

public class NowPlaying extends Fragment {

    @BindView(R.id.recyclerView)
    private RecyclerView mRecyclerView;

    MoviesAdapter mAdapter;
    List<MoviePopular> movies;
    MvpModel mp ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popular_fragment, container, false);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mAdapter = new MoviesAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

        mp.getPhotos("now_playing",new DataSource1.GetPhotosCallback() {
            @Override
            public void onSuccess(List<MoviePopular> photos) {
                movies = photos;
                mAdapter.setMovieList(movies);
                mAdapter.setCallback((MoviesAdapter.AdapterCallback) getActivity());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void tabPosition(int position) {

            }

            @Override
            public void onNetworkFailure() {
                Toast.makeText(getActivity(),"Network Error",Toast.LENGTH_SHORT).show();
            }
        });
       
        return view;
    }
}

