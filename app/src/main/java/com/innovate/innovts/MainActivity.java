package com.innovate.innovts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
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

import com.afollestad.materialdialogs.MaterialDialog;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.innovate.innovts.map.MapsFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import static com.innovate.innovts.R.styleable.NavigationDrawerDrawable;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private static final int REQUEST_CODE = 100;
    FloatingActionButton fab;
    SharedPreferences sharedpreferences;
    private TextView notificounter;
    private GoogleApiClient mGoogleApiClient;
    private Fragment fragment;
    NavigationView navigationView;
    public DatabaseReference mFirebaseDatabase;
    TextView email;
    double version = 1.0;

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

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        email = (TextView) header.findViewById(R.id.email);
        SharedPreferences sp = getSharedPreferences("auth", MODE_PRIVATE);
        email.setText(sp.getString("email", ""));
        startlocation();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Plus.API)
                .addScope(Plus.SCOPE_PLUS_LOGIN)
                .build();
        //  updateuserinfo();

    }

    protected void onStart() {
        super.onStart();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("version");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("database","database"+dataSnapshot.getValue());
               version = Double.parseDouble(String.valueOf(dataSnapshot.getValue()));
                Log.e("database", "mmmm" + version + "");
                checkUpdate("dont");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("database", databaseError + "");
            }
        });
    }

    //private String title;
    private void fragment() {
        if (fragment == null) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    if (!isFinishing()) {

                        getSupportFragmentManager().beginTransaction().replace(R.id.middlelayout, new MapsFragment(), "mapfrom").commit();
                    }
                }
            }, 1000);
            // getSupportFragmentManager().beginTransaction().replace(R.id.middlelayout, new MapsActivity2(), "mapfrom").commit();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (progressdialog!=null && progressdialog.isShowing()) {
            progressdialog.dismiss();
        }
        getSupportFragmentManager().beginTransaction().remove(new MapsFragment());
    }

    private void startlocation() {
        sharedpreferences = this.getSharedPreferences("auth", MODE_PRIVATE);
        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (!lm.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                !lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
        }
      //  AlertUtils.displayDialog(this, "Gps location is not active", "Please enable Location Services and GPS", "OK", "NO", "gps");

        //   Intent i = new Intent(this, BackgroundLocationService.class);
        // startService(i);
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
        Toast.makeText(this, "Loading.....", Toast.LENGTH_LONG);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Log.e("idmain", id + "" + R.id.about);
        if (id == R.id.logout) {

            SharedPreferences sp = getSharedPreferences("auth", MODE_PRIVATE);
            SharedPreferences.Editor et = sp.edit();
            et.clear();
            et.commit();
            if (mGoogleApiClient.isConnected()) {
                Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
                mGoogleApiClient.disconnect();
                //  mGoogleApiClient.connect();
                //  updateUI(false);
            }
            Intent i = new Intent(this, LoginActivity2.class);
            startActivity(i);
        } else if (id == R.id.about) {

            Intent i = new Intent(this,About.class);
            startActivity(i);
            overridePendingTransition(R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom);
        }
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
        fragment();
    }

    MaterialDialog progressdialog;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e("idselect", item.getItemId() + "here");
        switch (item.getItemId()) {
            case R.id.update:
                progressdialog = AlertDialogClass.displayMaterialProgressDialog(MainActivity.this, "Checking Update");
                checkUpdate("show");
        }
        return false;
    }

    private void checkUpdate(String show) {
        try {
            PackageInfo packageInfo = getApplicationContext().getPackageManager()
                    .getPackageInfo(getApplicationContext().getPackageName(), 0);
            double currentVersion = packageInfo.versionCode;
            if (version > currentVersion) {
                if(progressdialog!=null) {
                    progressdialog.dismiss();
                }
                String intent = ("https://play.google.com/store/apps/details?id=");
                AlertUtils.displayDialog(this, "UPDATE", "There is newer version of this application available, click update to upgrade now?", "Update", "Cancel", intent);
            } else {
                if(progressdialog!=null) {
                    progressdialog.dismiss();
                }
                if(show.equals("show")){
                AlertUtils.displayDialog(this, "UPDATE INFO", "Already uptodate", "OK", null, null);
            }}
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}

