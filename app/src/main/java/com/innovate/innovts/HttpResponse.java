package com.innovate.innovts;

import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.innovate.innovts.map.MapsActivity;
import com.squareup.okhttp.RequestBody;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by User on 5/9/2016.
 */
public class HttpResponse {
    static HttpRequest mHttpRequest;
    static JSONObject object;
    static double lat;
    static double lon;
    static String address;
    static ArrayList<String> doctype = new ArrayList();

    public static String listener(final String urltype, String url, final UICallback uIcallback, final int position) {
        mHttpRequest = new HttpRequest(url, null);
        Log.e("httpresponse", url);
        mHttpRequest.appendAppInfo(false);
        mHttpRequest.setOnBackgroundWorkListener(new HttpRequest.OnBackgroundWorkListener() {
            @Override
            public void performWork(HttpRequest.Status status, String result) {
                if (status == HttpRequest.Status.HTTP_SUCCESS) {
                   Log.e("result",result);
                    try {
                        fcm_history(result,position);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        // mHttpRequest.setOnResultsListener(this);



    mHttpRequest.setOnResultsListener(new HttpRequest.OnResultsListener() {
        @Override
        public void updateUI(HttpRequest.Status status, String result) throws JSONException {
            // Log.e("httpresponse", result);

                    uIcallback.update(lat,lon,address);
        }
    }
    );
    mHttpRequest.execute();
    return url;
}

    public static  void fcm_history(String result,int position) throws JSONException {
        if (result != null) {
            Gson gson = new Gson();
            ArrayList<JsonParser> a2;
            //  a1 = new ArrayList<>();
            a2 = new ArrayList<>();

                JSONArray mJsonArray = new JSONArray(result);
                JSONObject obj = mJsonArray.getJSONObject(position);
                lat = obj.getDouble("latitude");
                lon = obj.getDouble("longitude");

address=obj.getString("address");


            a2.clear();
            Log.e("fcm",position+"aa"+lat);
            try {
                Type listType = new TypeToken<ArrayList<JsonParser>>() {
                }.getType();
                ArrayList<JsonParser> array1;

                array1 = new GsonBuilder().create().fromJson(result, listType);
               /* for (JsonParser post : array1) {

                        a2.addAll(post.getLatitude());
                    }
                }*/

             lat=  array1.get(position).getLatitude();
              lon=  array1.get(position).getLongitude();
                Log.e("array","aa"+lat);

                  /*  for ( post : array1) {
                        for (int i = 0; i < post.getResponse().size(); i++) {
                            a2.clear();
                            a2.addAll(post.getResponse());
                        }
                    }


                }*/
            } catch (Exception e) {
                Log.e("catch",e.getMessage());
               // return null;
            }
        }
         ;
    }


}
