package com.innovate.innovts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;

import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;
import com.innovate.innovts.map.MapsActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private static final int REQUEST_CODE = 100;
    FloatingActionButton fab;
    SharedPreferences sharedpreferences;
    private TextView notificounter;
    private GoogleApiClient mGoogleApiClient;
    private Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("main", "oncreate");
        Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
        fragment = getSupportFragmentManager().findFragmentById(R.id.middlelayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragment();
        //  getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        startlocation();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Plus.API)
                .addScope(Plus.SCOPE_PLUS_LOGIN)
                .build();
        //  updateuserinfo();
    }


    //private String title;
    private void fragment() {
        if (fragment == null) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    if (!isFinishing()) {

                        getSupportFragmentManager().beginTransaction().replace(R.id.middlelayout, new MapsActivity(), "mapfrom").commit();
                    }
                }
            }, 1000);
            // getSupportFragmentManager().beginTransaction().replace(R.id.middlelayout, new MapsActivity2(), "mapfrom").commit();
        }
    }


    private void startlocation() {
        sharedpreferences = this.getSharedPreferences("login", MODE_PRIVATE);
        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (sharedpreferences.getBoolean("driver", false)) {
            if (!lm.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                    !lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            }
            AlertUtils.displayDialog(this, "Gps location is not active", "Please enable Location Services and GPS", "OK", "NO", "gps");

            //   Intent i = new Intent(this, BackgroundLocationService.class);
            // startService(i);
        } else {
            //  Intent i = new Intent(this, BackgroundLocationService.class);
            //  stopService(i);
        }
    }

    private static final int TIME_INTERVAL = 3000;
    private long mBackPressed;

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
            moveTaskToBack(true);

        } else {
            Toast.makeText(getBaseContext(), "Tap back button once more to exit", Toast.LENGTH_SHORT).show();
            mBackPressed = System.currentTimeMillis();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        final boolean usertyp = sharedPreferences.getBoolean("driver", false);

        //  MenuItem m = menu.findItem(R.id.next);
        Toast.makeText(this, "Loading.....", Toast.LENGTH_LONG);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

          /*else if (id == R.id.logout) {
                SharedPreferences prefs = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                //  editor.putBoolean("loggedin", false);
                editor.clear();
                editor.commit();
                if (mGoogleApiClient.isConnected()) {
                    Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
                    mGoogleApiClient.disconnect();
                    //  mGoogleApiClient.connect();
                    //  updateUI(false);
                }
                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);*/

        // LoginBaseActvity.signOutFromGplus(true);
        // }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void onDestroy() {
        //stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }

    public void animate(TextInputLayout id, Techniques anim) {
        YoYo.with(anim)
                .duration(700)
                .playOn(id);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

        }
        return false;
    }
}
