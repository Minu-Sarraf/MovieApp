package com.example.minu.movieapp.dragger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by leapfrog on 11/30/17.
 */

public class PresenterModule {
    @Provides
    @Singleton
    FoodzPresenter provideFoodzPresenter(Context context) {
        return new FoodzPresenterImpl(context);
    }

}
