package com.example.minu.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minu.movieapp.R;
import com.example.minu.movieapp.activity.DetailActivity;
import com.example.minu.movieapp.model.CreditModel;
import com.example.minu.movieapp.model.MoviePopular;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minu on 10/12/2017.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.MovieViewHolder> implements View.OnClickListener {

        private List<CreditModel.CastBean> mCastList;
        private LayoutInflater mInflater;
        public static final String TMDB_IMAGE_PATH = "http://image.tmdb.org/t/p/w500";
        private Context mContext;

        public DetailAdapter(Context context)
        {
            this.mContext = context;
            this.mInflater = LayoutInflater.from(context);
            this.mCastList = new ArrayList<>();
        }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.featured_cast, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        CreditModel.CastBean cast = mCastList.get(position);
        // This is how we use Picasso to load images from the internet.
        Picasso.with(mContext)
                .load(TMDB_IMAGE_PATH+ cast.getProfile_path())
                .into(holder.imageView);
        holder.imageView.setOnClickListener(this);
        holder.name.setText(cast.getName());
    }


    @Override
        public int getItemCount()
        {
            return (mCastList == null) ? 0 : mCastList.size();
        }

        public void setmCastList(List<CreditModel.CastBean> mCredit)
        {
            this.mCastList.clear();
            this.mCastList.addAll(mCredit);
            notifyDataSetChanged();
        }

        @Override
        public void onClick(View view) {
            if(view.getId() == (R.id.imageView)){
                Intent i = new Intent(mContext, DetailActivity.class);
                mContext.startActivity(i);
            }

        }

        static class MovieViewHolder extends RecyclerView.ViewHolder
        {
            public ImageView imageView;
            public TextView name;

            public MovieViewHolder(View itemView)
            {
                super(itemView);
                imageView = (ImageView) itemView.findViewById(R.id.featuredImage);
                name = (TextView)itemView.findViewById(R.id.fTitle);

            }
        }
    }

