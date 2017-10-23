package com.example.minu.movieapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minu.movieapp.R;

/**
 * Created by minu on 10/22/2017.
 */

public class Popular extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("Popular Fragment", "loaded");
        return inflater.inflate(R.layout.popular_fragment, container, false);
    }
}
