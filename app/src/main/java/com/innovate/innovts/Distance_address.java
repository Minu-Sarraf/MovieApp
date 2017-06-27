package com.innovate.innovts;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import java.util.List;
import java.util.Locale;

/**
 * Created by User on 7/4/2016.
 */
public class Distance_address {
    static String address;
    public static double distFrom(double lat1, double lon1, double lat2, double lon2) {
        LatLng from = new LatLng(lat1,lon1);
        LatLng to = new LatLng(lat2,lon2);

        //Calculating the distance in meters
        Double distance = SphericalUtil.computeDistanceBetween(from, to);

        //Displaying the distance
       Log.e("distance",distance+"m");
       /* Location selected_location = new Location("locationA");
        selected_location.setLatitude(lat1);
        selected_location.setLongitude(lon1);
        Location near_locations = new Location("locationA");
        near_locations.setLatitude(lat2);
        near_locations.setLongitude(lon2);

        Float distance = selected_location.distanceTo(near_locations);*/
        double meter = 0.000621371192;// Mile
        Log.e("distfrom", String.valueOf(distance*meter));
        return distance;
        /*double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);*/
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }


}
