package com.example.minu.movieapp.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minu.movieapp.R;
import com.example.minu.movieapp.model.MoviePopular;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minu on 10/5/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private List<MoviePopular> mMoviePopularList;
    private LayoutInflater mInflater;
    public static final String TMDB_IMAGE_PATH = "http://image.tmdb.org/t/p/w500";
    public Context mContext;
    public MoviesAdapter.AdapterCallback mAdapterCallback;


    public MoviesAdapter(Context context) {

        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMoviePopularList = new ArrayList<>();

    }

    // A method to set a callback from activity/fragment.
    public void setCallback(MoviesAdapter.AdapterCallback callback) {
        this.mAdapterCallback = callback;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder, int position) {
        Log.e("pager", ViewPager.generateViewId() + "");
        final MoviePopular moviePopular = mMoviePopularList.get(position);
        Picasso.with(mContext)
                .load(TMDB_IMAGE_PATH + moviePopular.getPosterPath()).placeholder(R.drawable.qfx)
                .into(holder.imageView, new com.squareup.picasso.Callback() {
                            @Override
                            public void onSuccess() {

                                holder.name.setText(moviePopular.getTitle());
                                holder.date.setText(moviePopular.getReleaseDate());
                            }

                            @Override
                            public void onError() {
                                //Error placeholder image already loaded into the view, do further handling of this situation here
                            }
                        }
                );


    }


    public static interface AdapterCallback {
        void onMethodCallback(int position, List<MoviePopular> mMoviePopularList);
    }

    @Override
    public int getItemCount() {
        return (mMoviePopularList == null) ? 0 : mMoviePopularList.size();
    }

    public void setMovieList(List<MoviePopular> moviePopularList) {
        this.mMoviePopularList.clear();
        this.mMoviePopularList.addAll(moviePopularList);
        notifyDataSetChanged();
    }


    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView name, date;


        public MovieViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            name = (TextView) itemView.findViewById(R.id.name);
            date = (TextView) itemView.findViewById(R.id.date1);
            imageView.setOnClickListener(this);
            //getAdapterPosition();
        }


        @Override
        public void onClick(View view) {
            if (view.getId() == (R.id.imageView)) {
                Log.e("position", getAdapterPosition() + "");
                try {
                    if (mAdapterCallback != null) {
                        mAdapterCallback.onMethodCallback(getAdapterPosition(), mMoviePopularList);
                    }
                } catch (ClassCastException exception) {
                    // do something
                }
            }
        }
    }
}
