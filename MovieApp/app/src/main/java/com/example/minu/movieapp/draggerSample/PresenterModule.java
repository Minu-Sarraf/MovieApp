package com.example.minu.movieapp.draggerSample;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    @Singleton
    FilmPresenter provideFoodzPresenter(Context context) {
        return new FilmPresenterImpl(context);
    }

}
