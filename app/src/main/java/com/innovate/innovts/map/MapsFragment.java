package com.innovate.innovts.map;


import android.Manifest;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;

import android.graphics.drawable.BitmapDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.innovate.innovts.Distance_address;
import com.innovate.innovts.HttpResponse;
import com.innovate.innovts.Permission;
import com.innovate.innovts.R;
import com.innovate.innovts.UICallback;
import com.innovate.innovts.checkinternet;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapsFragment extends Fragment implements plotmap.mapplot,UICallback,Runnable, GoogleMap.OnMyLocationChangeListener, OnMapReadyCallback, View.OnClickListener, AdapterView.OnItemSelectedListener {
    public GoogleMap mMap;
    Marker userMarker, childMarker;
    LatLng latLngpick;
    LatLng latlngdrop;
    double lat;
    Spinner spinner;
    double lon;
    private String pickadd;
    String address, oldAddress = "old";

    @Override
    public void plotroute(PolylineOptions lineoption) {
        mMap.clear();
        if (userMarker != null) {
            userMarker.remove();
        }
        distance = (float) Distance_address.distFrom(latLngpick.latitude, latLngpick.longitude, latlngdrop.latitude, latlngdrop.longitude);
        // Toast.makeText(getActivity(), "Distance: " + distance + " m", Toast.LENGTH_SHORT).show();
        addUserMarker("Current Location");
        addChildMarker(latlngdrop, "bus", address);
        if (lineoption != null) {
            Log.e("maplote", address + "here " + pickadd);
            mMap.addPolyline(lineoption);
        }

    }

    public void plot() {
        if (latlngdrop != null && latLngpick != null) {
            String url = plotmap.getDirectionsUrl(latLngpick, latlngdrop, getActivity());
            plotmap.DownloadTask downloadTask = new plotmap.DownloadTask(this);
            Log.e("mapsclick", url);
            // Start downloading json data from Google Directions API
            downloadTask.execute(url);
        }
    }

    Handler handler;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position > 0) {
            if (!checkinternet.displaynetstatus(getActivity(), true)) {
                HttpResponse.listener("position", "http://103.254.180.108:8082/api/positions", this, spinner.getSelectedItemPosition());


                handler.postDelayed(this,10000);
            }
            Log.e("item", spinner.getSelectedItemPosition() + "pos" + spinner.getSelectedItemId());
        }else{
            if (childMarker != null) {
                childMarker.remove();
                mMap.clear();
                addUserMarker(address);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    int flag = 0;

    @Override
    public void update(double lat1, double lon1, String address1) {
        Log.e("update", "update" + lon1 + "old " + oldAddress + "new" + address1 + oldAddress.equals(address1));
        latlngdrop = new LatLng(lat1, lon1);
        lat = lat1;
        lon = lon1;
        if (!address1.equalsIgnoreCase(oldAddress)) {
            if (address1 != null) {
                address = address1;
                addChildMarker(latlngdrop, "bus", address);
            } else {
                addChildMarker(latlngdrop, "bus", "Loading..");
                flag = 1;
                address = getaddress(latlngdrop);


            }
            plot();
        }
    }

    @Override
    public void refresh_interface(String b, int a) {

    }

    @Override
    public void getName(List<String> name) {
        List<String> uri = new ArrayList<>();
      //  sp.setRefreshing(false);
        if (childMarker != null) {
            childMarker.remove();
        }
        if (name != null) {
            uri = name;
            getBusNumber(uri);
        } else {
            uri.add("No Device Found");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        }

        return false;
    }


    // String[] uri = new String[]{"Please Select Bus", "2", "3", "5", "7", "8"};

    public void getBusNumber(List<String> uri) {
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> typelist;
        typelist = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, uri);
        spinner.setAdapter(typelist);
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(this,10000);
        if (!checkinternet.displaynetstatus(getActivity(), true)) {
            HttpResponse.listener("users", "http://103.254.180.108:8082/api/devices", this, 0);
        }
    }

    //SwipeRefreshLayout sp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //  setContentView(R.layout.activity_maps);
        View rootView = inflater.inflate(R.layout.activity_maps, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);
        spinner = (Spinner) rootView.findViewById(R.id.spinner);
        mapFragment.getMapAsync(this);
      //  sp = (SwipeRefreshLayout) rootView.findViewById(R.id.refresh);
       // sp.setRefreshing(false);
       // sp.setOnClickListener(this);
        handler = new Handler();
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //trySwipeRefreshLayout();
        return rootView;
    }

    public String getaddress(final LatLng latLng) {
        // checkinternet.displaynetstatus(getActivity(), true);
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                Geocoder myLocation = new Geocoder(getActivity(), Locale.getDefault());
                try {
                    List<Address> myList = myLocation.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    if (myList != null && myList.size() > 0) {
                        pickadd = "";
                        pickadd = myList.get(0).getAddressLine(0) + ", " + myList.get(0).getLocality();
                        Log.e("getadd", pickadd + "none");
                    }
                } catch (Exception e) {
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (flag == 1) {
                            childMarker.setTitle(pickadd);
                            childMarker.showInfoWindow();
                            flag = 0;
                        } else {
                            userMarker.setTitle(pickadd);
                            userMarker.showInfoWindow();
                        }

                    }
                });
            }
        });
        th.start();

        return pickadd;
    }

    boolean result;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMyLocationChangeListener(this);
        result = Permission.Utility.checkPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION, 124, "Location permission is necessary");
        mMap.setMyLocationEnabled(true);
        initializeMap();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 124: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //   mMap.setOnMapClickListener(this);
                    initializeMap();
                } else {
                }
                return;
            }
        }
    }

    private void initializeMap() {
        Log.e("mymap", "inside initializemap()");
        GoogleMapOptions options = new GoogleMapOptions();
        options.mapType(GoogleMap.MAP_TYPE_NORMAL)
                .compassEnabled(true)
                .tiltGesturesEnabled(true)
                .rotateGesturesEnabled(true)
                .zoomControlsEnabled(true)
                .zoomGesturesEnabled(true);
        mMap.setPadding(0, dpToPx(70), 0, 0);
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    MapView mv = new MapView(getActivity());
                    mv.onCreate(null);
                    mv.onPause();
                    mv.onDestroy();
                } catch (Exception ignored) {

                }
            }
        }).start();
    }

    float distance;
   /* private void trySwipeRefreshLayout() {
        if (sp != null) {
            sp.setColorSchemeResources(
                    R.color.materialred,
                    R.color.colorPrimary,
                    R.color.materialyellow);
        }
        sp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                sp.setRefreshing(true);
                if (!checkinternet.displaynetstatus(getActivity(), true)) {
                    HttpResponse.listener("users", "http://103.254.180.108:8082/api/devices",MapsFragment.this, 0);
                }
            }ps

        });
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           /* case (R.id.fabsave):
                save_add("fab");
                break;
            case (R.id.searchfrom):
                search123(etfrom, latLngpick);
                break;
            case (R.id.searchto):
                search123(etto, latlngdrop);
                break;*/
        }
    }

    public void save_add(String save) {
        if (latlngdrop != null && latLngpick != null) {
            Log.e("distance", latLngpick + "drop " + latlngdrop);

            distance = (float) Distance_address.distFrom(latLngpick.latitude, latLngpick.longitude, latlngdrop.latitude, latlngdrop.longitude);

        } else {
            Log.e("mapsclick", "latlngpick is null");
        }
    }

  /*  @Override
    public void onMapClick(LatLng point) {
        if (userMarker != null) {
            userMarker.remove();
        }
        lat = point.latitude;
        lon = point.longitude;
        latLngpick = new LatLng(lat, lon);
        Log.e("onmapclck", latLngpick + "");
        addUserMarker(latLngpick, "Loading...","");
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngpick, 8f));
        userMarker.showInfoWindow();
       *//* double precision = Math.pow(10, 6);
        double new_Latitude = (((precision * lat)) / precision);
        double new_Longitude = (((precision * lat)) / precision);*//*
    }*/

    private void addUserMarker(String address) {


        BitmapDrawable bitmapDrawable;
        int height = 80;
        int width = 65;


        if (userMarker != null) {
            userMarker.remove();
        }
        pickadd = getaddress(latLngpick);
        bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.ic_person_pin_circle);


        Bitmap b = bitmapDrawable.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);

        userMarker = mMap.addMarker(new MarkerOptions()
                .position(latLngpick)
                .title(address)
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
        userMarker.showInfoWindow();
    }




    private void addChildMarker(final LatLng loc, String title, String address) {
        Log.e("markr", title);
        oldAddress = address;
        BitmapDrawable bitmapDrawable;
        int height = 80;
        int width = 65;
        if (title.equalsIgnoreCase("bus")) {
            if (childMarker != null) {
                childMarker.remove();
            }
        }
        bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.bus);
        Bitmap b = bitmapDrawable.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
        oldAddress = address;
        childMarker = mMap.addMarker(new MarkerOptions()
                .position(loc)
                .title(address)
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
        childMarker.showInfoWindow();
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

//        handler.removeCallbacks((Runnable) MapsFragment.this);

    }

    @Override
    public void onMyLocationChange(Location location) {
        //  mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 18f));
        Log.e("map", "locchange");
        LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
        if (userMarker == null && loc != latLngpick) {
            lat = location.getLatitude();
            lon = location.getLongitude();
            latLngpick = new LatLng(lat, lon);
            Log.e("mylocchange", latLngpick + "");
            pickadd = getaddress(loc);
            addUserMarker(pickadd);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 12f));
            userMarker.showInfoWindow();
        }
        //  mMap.setOnMyLocationChangeListener(null);
        //stop location updates
    }

    @Override
    public void run() {
        HttpResponse.listener("position", "http://103.254.180.108:8082/api/positions", MapsFragment.this, spinner.getSelectedItemPosition());
        handler.postDelayed(this, 10000);

    }
}