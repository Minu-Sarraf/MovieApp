package com.innovate.innovts;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;



/**
 * Created by Soniya on 7/10/2015.
 */
public class AlertUtils {

    public static void displayDialog(final Context context, String title, String msg, String positiveText, String negativeText, final String subject) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.MyAlertDialogStyle)
                .setCancelable(false)
                .setTitle(title)
                .setMessage(msg);
        if (positiveText != null) {
            builder.setCancelable(false);
            builder.setPositiveButton(positiveText,
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            if ( subject!=null && subject.equalsIgnoreCase("gps")) {
                                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                context.startActivity(intent);
                            }else if (subject!=null){
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(subject));
                                context.startActivity(intent);
                            }else{
                                builder.setCancelable(true);
                            }
                        }
                    });
        } else {
            builder.setCancelable(true);
        }
        if (negativeText != null) {

            builder.setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    if (subject!=null ) {
                        builder.setCancelable(true);
                    }
                }
            });
        }
        builder.create().show();
    }

}
