package com.innovate.innovts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        TextView tv = (TextView) findViewById(R.id.text);
        pg=(ProgressView)findViewById(R.id.splash);
        Typeface fontHindi = Typeface.createFromAsset(getAssets(),
                "fonts/Ananda Lipi Bold Cn Bt.ttf");
        //  fillableLoader = (FillableLoader) findViewById(R.id.fillableLoader);
       tv.setText("innoVAKE");

        final SharedPreferences prefs = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("loggedin", true);
        pg.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                pg.setVisibility(View.INVISIBLE);
                if(prefs.getBoolean("loggedin",false)){
                    Intent i = new Intent(Awesomesplash.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }else {
                    Intent i = new Intent(Awesomesplash.this,MainActivity.class);
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
