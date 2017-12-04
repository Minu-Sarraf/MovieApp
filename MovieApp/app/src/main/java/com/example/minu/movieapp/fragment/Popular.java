package com.example.minu.movieapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minu.movieapp.MovieContract;
import com.example.minu.movieapp.MvpModel;
import com.example.minu.movieapp.Presenter;
import com.example.minu.movieapp.R;
import com.example.minu.movieapp.adapter.MoviesAdapter;
import com.example.minu.movieapp.model.MoviePopular;
import com.rey.material.widget.ProgressView;

import java.util.List;

/**
 * Created by minu on 10/22/2017.
 */

public class Popular extends Fragment implements MovieContract.View {


    String cat;
    MovieContract.Presenter pp;
    private RecyclerView mRecyclerView;
    private MoviesAdapter mAdapter;
    ProgressView pb;


    public Popular(String cat) {
        this.cat = cat;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pp = new Presenter(this, new MvpModel(), cat);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popular_fragment, container, false);
       // pb = (ProgressView) view.findViewById(R.id.progressbar);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        pp.getPhotos(getActivity());

        return view;


    }

    @Override
    public void showPhotos(List<MoviePopular> photos, String cat, Context c) {
        mAdapter = new MoviesAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setMovieList(photos);
        mAdapter.setCallback((MoviesAdapter.AdapterCallback) c);
    }

    @Override
    public void showToastMessage(String message) {

    }

    @Override
    public void setProgressBar(boolean show) {
       /* if(show) {

            mRecyclerView.setVisibility(View.GONE);
            pb.setVisibility(View.VISIBLE);
        }else {
            mRecyclerView.setVisibility(View.VISIBLE);
            pb.setVisibility(View.INVISIBLE);
        }*/
    }
}
