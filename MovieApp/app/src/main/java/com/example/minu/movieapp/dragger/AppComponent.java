package com.example.minu.movieapp.dragger;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class,PresenterModule.class})
public interface AppComponent {
    void inject(FoodzActivity target);
    void inject(FoodzPresenterImpl target);

}
