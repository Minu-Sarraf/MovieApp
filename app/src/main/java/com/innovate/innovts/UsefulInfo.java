package com.innovate.innovts;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;

/**
 * Created by User on 6/30/2016.
 */
public class UsefulInfo {
    public static String regId;
    public static String imeiId;
    public static String exusername;

    public static FormEncodingBuilder addpostdata(String a) {


            return new FormEncodingBuilder().add("token","twGNC6U348pUzrYluzCgeHiZaqcnVtc2");

    }


    /*public static void setImeiId(String imeiId) {

        UsefulInfo.imeiId = imeiId;
    }*/
}
