package com.innovate.innovts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setHomeButtonEnabled(true);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}