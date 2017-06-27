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
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
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


import java.util.List;
import java.util.Locale;

public class MapsActivity extends Fragment implements plotmap.mapplot, UICallback, GoogleMap.OnMyLocationChangeListener, OnMapReadyCallback, View.OnClickListener, AdapterView.OnItemSelectedListener {
    public GoogleMap mMap;
    Marker userMarker, childMarker;
    LatLng latLngpick;
    LatLng latlngdrop;
    double lat;
    Spinner spinner;
    double lon;
    private String pickadd;
    String address;

    @Override
    public void plotroute(PolylineOptions lineoption) {
        mMap.clear();
        if (userMarker != null) {
            userMarker.remove();
        }
        distance = (float) Distance_address.distFrom(latLngpick.latitude, latLngpick.longitude, latlngdrop.latitude, latlngdrop.longitude);
       // Toast.makeText(getActivity(), "Distance: " + distance + " m", Toast.LENGTH_SHORT).show();
        addUserMarker(latLngpick, "Current Location", "Current Location");
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
            HttpResponse.listener("position", "http://103.254.180.108:8082/api/positions", this, spinner.getSelectedItemPosition());

            handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms

                    HttpResponse.listener("position", "http://103.254.180.108:8082/api/positions", MapsActivity.this, spinner.getSelectedItemPosition());
                    handler.postDelayed(this,10000);

                }
            }, 10000);
            Log.e("item", spinner.getSelectedItemPosition() + "pos" + spinner.getSelectedItemId());
       /* latlngdrop = new LatLng(27.681724721752698, 85.52912872284651);
        if (position > 1) {
            lat=27.681724721752698;
            lon=85.52912872284651;

        }*/
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    int flag = 0;

    @Override
    public void update(double lat1, double lon1, String address1) {
        Log.e("update", "update" + lon1);
        latlngdrop = new LatLng(lat1, lon1);
        lat = lat1;
        lon = lon1;
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

    @Override
    public void refresh_interface(String b, int a) {

    }


    public interface calacivity {
        void mapfrom(double lat, double lng, String type);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        //   setContentView(R.layout.activity_maps);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           /* case R.id.next:
                save_add("next");
                // Do Fragment menu item stuff here
                return true;

            default:
                break;*/
        }

        return false;
    }

    String[] uri = new String[]{"Please Select Bus", "BUS2", "barsha", "saajan", "dipesh", "ajay"};
    // String[] uri = new String[]{"Please Select Bus", "2", "3", "5", "7", "8"};


    public void getBusNumber() {
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> typelist;
        //latlngdrop = new LatLng()
        typelist = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, uri);
        spinner.setAdapter(typelist);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //  setContentView(R.layout.activity_maps);
        View rootView = inflater.inflate(R.layout.activity_maps, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);
        spinner = (Spinner) rootView.findViewById(R.id.spinner);
        Log.e("map", "oncreate");
        mapFragment.getMapAsync(this);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        // checkinternet.displaynetstatus(getActivity(), true);
        getBusNumber();
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

        //  result = Permission.Utility.checkPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION, 124, "Location permission is necessary");
        // mMap.setOnMapClickListener(MapsActivity.this);
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
            // other 'case' lines to check for other
            // permissions this app might request
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

        //  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngpick, 8f));
        //  addUserMarker(latLngpick, "here");
        //  userMarker.showInfoWindow();
    }

    // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(28.3974557, 84.1299978), 5.5f));
       /* addUserMarker(new LatLng(28.3974557, 84.1299978),"Loading...");
        userMarker.setTitle("Nepal");*/
    //  userMarker.showInfoWindow();
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

    private void addUserMarker(final LatLng loc, String title, String address) {
        Log.e("markr", title);

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
                .position(loc)
                .title(address)
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
        userMarker.showInfoWindow();
    }

    private void addChildMarker(final LatLng loc, String title, String address) {
        Log.e("markr", title);

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

        childMarker = mMap.addMarker(new MarkerOptions()
                .position(loc)
                .title(address)
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
        childMarker.showInfoWindow();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

       // handler.removeCallbacks();

    }

    @Override
    public void onMyLocationChange(Location location) {
        //  mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 18f));
        Log.e("map", "locchange");
        if (userMarker == null) {
            lat = location.getLatitude();
            lon = location.getLongitude();
            latLngpick = new LatLng(lat, lon);
            Log.e("mylocchange", latLngpick + "");
            LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
            pickadd = getaddress(loc);
            addUserMarker(loc, "Current Position", pickadd);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 12f));
            userMarker.showInfoWindow();
        }
        //  mMap.setOnMyLocationChangeListener(null);
        //stop location updates
    }
}