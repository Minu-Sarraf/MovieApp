package com.innovate.innovts;

import android.app.Application;
import android.content.Context;

/**
 * Created by User on 6/30/2016.
 */
public class MyApplication extends Application {
    private static final String PROPERTY_ID = "UA-60329710-1";
    static MyApplication mInstance;
    public enum TrackerName {
        APP_TRACKER
    }

 //   HashMap<TrackerName, Tracker> mTrackers = new HashMap<TrackerName, Tracker>();

   /* synchronized Tracker getTracker(TrackerName trackerId) {
        if (!mTrackers.containsKey(trackerId)) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            Tracker t = analytics.newTracker(PROPERTY_ID);
            mTrackers.put(trackerId, t);
        }
        return mTrackers.get(trackerId);
    }*/
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
      //  MultiDex.install(this);
    }
    @Override
    public Context getApplicationContext() {
        return super.getBaseContext();
    }
    @Override
    public Context getBaseContext() {
        return super.getBaseContext();
    }
    public static synchronized MyApplication getInstance() {
        return mInstance;
    }
}
