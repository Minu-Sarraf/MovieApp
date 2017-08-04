package com.innovate.innovts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.rey.material.widget.ProgressView;


/**
 * Created by User on 10/21/2016.
 */
public class Awesomesplash extends Activity {
    private static final long SPLASH_TIME_OUT = 3000;
    String generatedSvgPath;

    ProgressView pg;
    String versionName;
    int versionCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView tv = (TextView) findViewById(R.id.text);
        TextView name = (TextView) findViewById(R.id.name);
        TextView version = (TextView) findViewById(R.id.version);
        pg = (ProgressView) findViewById(R.id.splash);
        tv.setText("innoVake");
        SharedPreferences sp =getSharedPreferences("auth",MODE_PRIVATE);
        Log.e("splash",sp.getString("email",""));
        name.setText(sp.getString("email",""));
        try {
            versionName = getApplicationContext().getPackageManager()
                    .getPackageInfo(getApplicationContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        try {
            versionCode = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        version.setText("Version: " + versionName + " (" + versionCode + ")");
        final SharedPreferences prefs = getSharedPreferences("auth", Context.MODE_PRIVATE);
        pg.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pg.setVisibility(View.INVISIBLE);
                if (!prefs.getString("email", "").equals("")) {
                    Intent i = new Intent(Awesomesplash.this, MainActivity.class);
                    startActivity(i);
                   // finish();
                } else {
                    Intent i = new Intent(Awesomesplash.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        }, SPLASH_TIME_OUT);

        // fillableLoader.setSvgPath(Path.path);
    }

    private Boolean exit = false;

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 1 * 1000);

        }

    }


}
