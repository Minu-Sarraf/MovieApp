package com.example.minu.movieapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minu.movieapp.R;

/**
 * Created by minu on 10/22/2017.
 */

public class Upcoming extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.upcoming_fragment, container, false);
    }

}
