package com.example.minu.movieapp.dragger;

import android.app.Application;



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
