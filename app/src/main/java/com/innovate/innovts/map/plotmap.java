package com.innovate.innovts.map;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 10/5/2016.
 */
public class plotmap {
    // static GoogleMap map;

    public static String getDirectionsUrl(LatLng origin, LatLng dest, Activity activity) {
        // map = map1;
        // Origin of route
        String str_dest = null;
        String str_origin = null;
        if (origin != null) {
            str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        } else {
            Toast.makeText(activity, "Please enter pickup location", Toast.LENGTH_SHORT).show();
        }
        // Destination of route
        if (dest != null) {
            str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        } else {
            Toast.makeText(activity, "Please enter destination location", Toast.LENGTH_SHORT).show();
        }
        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;

        return url;
    }

    /**
     * A method to download json data from url
     */
    private static String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            // Log.d("Exception while downloading url", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    public interface mapplot {
        void plotroute(PolylineOptions lineoption);
    }

    // Fetches data from url passed
    public static class DownloadTask extends AsyncTask<String, PolylineOptions, String> {
        private final MapsFragment activity;

        public DownloadTask(MapsFragment mmap) {
            this.activity = mmap;
        }

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
                Log.e("downloadtask", data);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }


        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask(activity);

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }

        private static class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {
            private final MapsFragment activity;

            public ParserTask(MapsFragment mmap) {
                this.activity = mmap;
            }

            // Parsing the data in non-ui thread
            @Override
            protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

                JSONObject jObject;
                List<List<HashMap<String, String>>> routes = null;

                try {
                    jObject = new JSONObject(jsonData[0]);
                    DirectionsJSONParser parser = new DirectionsJSONParser();

                    // Starts parsing data
                    routes = parser.parse(jObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return routes;
            }

            // Executes in UI thread, after the parsing process
            @Override
            protected void onPostExecute(List<List<HashMap<String, String>>> result) {
                ArrayList<LatLng> points = null;
                PolylineOptions lineOptions = null;
                MarkerOptions markerOptions = new MarkerOptions();
                if (result.size() > 0) {
                    // Traversing through all the routes
                    for (int i = 0; i < result.size(); i++) {
                        points = new ArrayList<LatLng>();
                        lineOptions = new PolylineOptions();

                        // Fetching i-th route
                        List<HashMap<String, String>> path = result.get(i);

                        // Fetching all the points in i-th route
                        for (int j = 0; j < path.size(); j++) {
                            HashMap<String, String> point = path.get(j);

                            double lat = Double.parseDouble(point.get("lat"));
                            double lng = Double.parseDouble(point.get("lng"));
                            LatLng position = new LatLng(lat, lng);
                            //  Log.e("plotposition", position + "" + result.size() + "");
                            points.add(position);
                        }

                        // Adding all the points in the route to LineOptions
                        lineOptions.addAll(points);
                        lineOptions.width(8);
                        lineOptions.color(Color.RED);
                    }

                    activity.plotroute(lineOptions);
                    // Drawing polyline in the Google Map for the i-th route
                    //map.addPolyline(lineOptions);
                }
            }
        }
    }

    /**
     * A class to parse the Google Places in JSON format
     */

}
