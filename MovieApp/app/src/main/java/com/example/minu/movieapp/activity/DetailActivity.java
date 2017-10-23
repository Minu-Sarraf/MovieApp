package com.example.minu.movieapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.minu.movieapp.R;
import com.example.minu.movieapp.Utility;
import com.example.minu.movieapp.adapter.DetailAdapter;
import com.example.minu.movieapp.adapter.MoviesAdapter;
import com.example.minu.movieapp.model.CreditModel;
import com.example.minu.movieapp.model.MoviePopular;
import com.example.minu.movieapp.model.MoviesResponse;
import com.example.minu.movieapp.model.VideoModel;
import com.example.minu.movieapp.rest.ApiInterface;
import com.example.minu.movieapp.rest.ApiList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private DetailAdapter mAdapter;
    ImageView image, icon;
    TextView txname, txDetail, txDate, reviewTitle;
    RatingBar ratingBar;
    Button play;
    MoviePopular movie;
    String key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mRecyclerView = (RecyclerView) findViewById(R.id.gridView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mAdapter = new DetailAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        play = (Button) findViewById(R.id.play);
        play.setOnClickListener(this);
        txname = (TextView) findViewById(R.id.name);
        txDetail = (TextView) findViewById(R.id.reviewDesc);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txDate = (TextView) findViewById(R.id.date);
        reviewTitle = (TextView) findViewById(R.id.reviewTitle);
        image = (ImageView) findViewById(R.id.imageView);
        icon = (ImageView) findViewById(R.id.pp);
        setData();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //overridePendingTransition( R.anim.abc_slide_out_bottom,R.anim.abc_slide_in_top);
    }

    private void setData() {
        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);
        ArrayList<MoviePopular> detail = new ArrayList<>();
        detail.clear();
        ArrayList<MoviePopular> mDetail;
        mDetail = i.getParcelableArrayListExtra("popular");
        detail.addAll(mDetail);
        MoviePopular movie = detail.get(position);
        ratingBar.setStepSize((float) 0.05);
        ratingBar.setRating(movie.getVoteAverage());
        Log.e("popular", movie.getId() + "  rating   " + movie.getVoteAverage());
        txDetail.setText(detail.get(position).getOverview());
        Picasso.with(this)
                .load(ApiList.TMDB_IMAGE_PATH + movie.getPosterPath()).fit()
                .into(image);

        Picasso.with(this)
                .load(ApiList.TMDB_IMAGE_PATH + movie.getBackdropPath()).fit()
                .into(icon);
        txDate.setText(movie.getReleaseDate());
        txname.setText(movie.getOriginalTitle());

        ApiInterface apiService = ApiList.getClient().create(ApiInterface.class);

        Call<CreditModel> call = apiService.getCredit(movie.getId().toString(), ApiList.API_KEY);
        call.enqueue(new Callback<CreditModel>() {
            @Override
            public void onResponse(Call<CreditModel> call, Response<CreditModel> response) {
                Log.e("response", response.body().getCast() + "");
                List<CreditModel.CastBean> credit = new ArrayList<CreditModel.CastBean>();
                credit = response.body().getCast();
                mAdapter.setmCastList(credit);
                //   mAdapter.setCallback(DetailActivity.this);
            }

            @Override
            public void onFailure(Call<CreditModel> call, Throwable t) {
            }
        });


        Call<VideoModel> call1 = apiService.getVideos(movie.getId(), ApiList.API_KEY);

        call1.enqueue(new Callback<VideoModel>() {
            @Override
            public void onResponse(Call<VideoModel> call1, Response<VideoModel> response) {
                Log.e("response", response.body().getResults().get(0).getKey() + "");

                List<VideoModel.ResultsBean> credit = new ArrayList<VideoModel.ResultsBean>();
                credit = response.body().getResults();
                Log.e("movie", credit.get(0).getKey());
                key = credit.get(0).getKey();
            }

            @Override
            public void onFailure(Call<VideoModel> call, Throwable t) {
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.play) {
            Log.e("movie", key);
            Utility.watchYoutubeVideo(key, this);
        }
    }
}
