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
    RecyclerView foodzRecyclerView;


   //// @BindView(R.id.popular_fragment)
   // ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popular_fragment);

        ((FilmApplication) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);

        //Bindview was giving null so temporary solution
        foodzRecyclerView = findViewById(R.id.recyclerView);
        foodzRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter.setView(this);
        presenter.getFoodz();
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
    public void showFoodz(List<MoviePopular>movies) {
        mAdapter = new MoviesAdapter(this);

        foodzRecyclerView.setAdapter(mAdapter);
        mAdapter.setMovieList(movies);
//        mAdapter.setCallback((MoviesAdapter.AdapterCallback) this);
        foodzRecyclerView.getAdapter().notifyDataSetChanged();
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
