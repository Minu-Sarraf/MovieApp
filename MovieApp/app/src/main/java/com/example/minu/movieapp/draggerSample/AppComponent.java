package com.example.minu.movieapp.draggerSample;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class,PresenterModule.class,NetworkModule.class})
public interface AppComponent {
    void inject(FilmActivity target);
    void inject(FilmPresenterImpl target);

}
