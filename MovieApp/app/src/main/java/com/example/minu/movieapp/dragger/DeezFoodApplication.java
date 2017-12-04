package com.example.minu.movieapp.dragger;

import android.app.Application;

/**
 * Created by leapfrog on 11/30/17.
 */

public class DeezFoodApplication extends Application {
    private AppComponent appComponent ;


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    protected AppComponent initDagger(DeezFoodApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }


}
