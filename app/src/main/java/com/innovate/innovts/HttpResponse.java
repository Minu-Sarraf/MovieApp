package com.innovate.innovts;

import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
                Log.e("result", result + status);
                if (status == HttpRequest.Status.HTTP_SUCCESS) {

                    try {
                        if (urltype.equals("position")) {
                            fcm_history(result, position - 1);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("response", e.getCause() + e.getMessage());
                    }

                }else {
                    if(uIcallback.equals("auth"))
                    uIcallback.getName(null);
                }
            }
        });
        // mHttpRequest.setOnResultsListener(this);


        mHttpRequest.setOnResultsListener(new HttpRequest.OnResultsListener() {
                                              @Override
                                              public void updateUI(HttpRequest.Status status, String result) throws JSONException {
                                                  // Log.e("httpresponse", result);
                                                  if (urltype.equalsIgnoreCase("position")) {
                                                      uIcallback.update(lat, lon, address);

                                                  } else {
                                                      Log.e("listener",urltype);
                                                      uIcallback.getName(getName1(result));
                                                  }

                                              }
                                          }
        );
        mHttpRequest.execute();
        return url;
    }

    private static List<String> getName1(String result) {
        ArrayList<String> name = new ArrayList<String>();

//        name.clear();
        JSONArray mJsonArray = null;
        try {
            mJsonArray = new JSONArray(result);
        //    JSONObject obj = mJsonArray.getJSONObject(0);
            name.add("Please Select Device");
            for (int i=0;i<mJsonArray.length();i++){
                JSONObject obj = mJsonArray.optJSONObject(i);
                name.add(obj.get("name").toString());
                Log.e("device",mJsonArray.length()+"");
            }
        } catch (JSONException e) {
            e.printStackTrace();
            name.add("No device found");
        }


        return name;
    }

    public static void fcm_history(String result, int position) throws JSONException {
        if (result != null) {
            Gson gson = new Gson();
            ArrayList<JsonParser> a2;
            //  a1 = new ArrayList<>();
            a2 = new ArrayList<>();

            JSONArray mJsonArray = new JSONArray(result);
            JSONObject obj = mJsonArray.getJSONObject(position);
            lat = obj.getDouble("latitude");
            lon = obj.getDouble("longitude");

            address = obj.getString("address");


            a2.clear();
            Log.e("fcm", position + "aa" + lat);
            try {
                Type listType = new TypeToken<ArrayList<JsonParser>>() {
                }.getType();
                ArrayList<JsonParser> array1;

                array1 = new GsonBuilder().create().fromJson(result, listType);

                lat = array1.get(position).getLatitude();
                lon = array1.get(position).getLongitude();
                Log.e("array", "aa" + lat);

            } catch (Exception e) {
                Log.e("catch", e.getMessage());
                // return null;
            }
        }
        ;
    }


}

