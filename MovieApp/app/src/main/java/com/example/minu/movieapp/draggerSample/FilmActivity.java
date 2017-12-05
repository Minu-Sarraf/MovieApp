package com.example.minu.movieapp.draggerSample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.minu.movieapp.R;
import com.example.minu.movieapp.adapter.MoviesAdapter;
import com.example.minu.movieapp.model.MoviePopular;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FilmActivity extends AppCompatActivity implements FilmView {
    @Inject
    FilmPresenter presenter;

    @BindView(R.id.recyclerView)
    RecyclerView filmzRecyclerView;


   //// @BindView(R.id.popular_fragment)
   // ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popular_fragment);

        ((FilmApplication) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);

        //Bindview was giving null so temporary solution
        filmzRecyclerView = findViewById(R.id.recyclerView);
        
        
        filmzRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter.setView(this);
        presenter.getFilmz();
    }

  /*
   * FilmView
   */

    @Override
    public void showLoading() {
       // progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
     //   progressBar.setVisibility(View.GONE);
    }
    MoviesAdapter mAdapter;

    @Override
    public void showFilmz(List<MoviePopular>movies) {
        mAdapter = new MoviesAdapter(this);

        filmzRecyclerView.setAdapter(mAdapter);
        mAdapter.setMovieList(movies);
//        mAdapter.setCallback((MoviesAdapter.AdapterCallback) this);
        filmzRecyclerView.getAdapter().notifyDataSetChanged();
    }


    @Override
    public void showErrorMessage() {
       // Toast.makeText(this, R.string.FoodzListError, Toast.LENGTH_SHORT).show();
    }

   /* @Override
    public void launchFoodDetail(List<MoviePopular> foodzItem) {
        FoodActivity.launch(this, foodzItem);
    }*/

}
