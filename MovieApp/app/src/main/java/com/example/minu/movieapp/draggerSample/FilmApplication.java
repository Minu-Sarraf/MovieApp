package com.example.minu.movieapp.draggerSample;

import android.app.Application;



public class FilmApplication extends Application {
    private AppComponent appComponent ;


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    protected AppComponent initDagger(FilmApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }


}
