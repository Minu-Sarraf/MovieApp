package com.innovate.innovts;

import android.*;
import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.innovate.innovts.map.plotmap;

public class MapsActivity2 extends Fragment implements plotmap.mapplot, GoogleMap.OnMyLocationChangeListener, OnMapReadyCallback, View.OnClickListener, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //  setContentView(R.layout.activity_maps);
        View rootView = inflater.inflate(R.layout.activity_maps2, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        Log.e("map", "oncreate");
        mapFragment.getMapAsync(this);
        return rootView;
    }
    boolean result;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Log.e("map", "create");
        // setContentView(R.layout.activity_maps);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Log.e("map", "ready");
        mMap = googleMap;
        //result = Permission.Utility.checkPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION, 124, "Location permission is necessary");
        mMap.setOnMapClickListener(MapsActivity2.this);
        mMap.setOnMyLocationChangeListener(this);
        result = Permission.Utility.checkPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION, 124, "Location permission is necessary");
        mMap.setMyLocationEnabled(true);
        initializeMap();
    }
    private void initializeMap() {
        Log.d("mymap", "inside initializemap()");
        GoogleMapOptions options = new GoogleMapOptions();
        options.mapType(GoogleMap.MAP_TYPE_NORMAL)
                .compassEnabled(true)
                .tiltGesturesEnabled(true)
                .rotateGesturesEnabled(true)
                .zoomControlsEnabled(true)
                .zoomGesturesEnabled(true);

       // mMap.setPadding(0, dpToPx(70), 0, 0);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public void onMyLocationChange(Location location) {

    }

    @Override
    public void plotroute(PolylineOptions lineoption) {

    }
}
