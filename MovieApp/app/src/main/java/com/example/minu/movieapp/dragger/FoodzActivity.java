package com.example.minu.movieapp.dragger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.minu.movieapp.R;
import com.example.minu.movieapp.adapter.MoviesAdapter;
import com.example.minu.movieapp.model.MoviePopular;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


class FoodzActivity extends AppCompatActivity implements FoodzView {
    @Inject
    FoodzPresenter presenter;

    @BindView(R.id.recyclerView)
    RecyclerView foodzRecyclerView;


   //// @BindView(R.id.popular_fragment)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((DeezFoodApplication) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);

        foodzRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter.setView(this);
        presenter.getFoodz();
    }

  /*
   * FoodzView
   */

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showFoodz(List<MoviePopular> foodzItemList) {
        foodzRecyclerView.setAdapter(new MoviesAdapter(this));
      //  foodzRecyclerView.setMovieList(movies);
       // mAdapter.setCallback((MoviesAdapter.AdapterCallback) getActivity());
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
