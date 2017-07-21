package com.innovate.innovts;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
/**
 * Created by User on 7/1/2016.
 */
public class AlertDialogClass {
    //ask aboutwid library



    public static void display_dialog(final Activity activity, String title, String message, String positivetext, String negativetext) {
        if (!(activity.isFinishing())) {
            //show dialog

            AlertDialog.Builder dlgAlert;
            dlgAlert = new AlertDialog.Builder(activity);
            LayoutInflater inflater = activity.getLayoutInflater();
            View view = inflater.inflate(R.layout.customdialogtoolbar, null);
            // dlgAlert.setIcon(R.drawable.ic_crop_white_18dp);
            dlgAlert.setTitle(title).setCustomTitle(view);
            dlgAlert.setMessage(message);
            if (positivetext != null) {
                dlgAlert.setCancelable(false);
                dlgAlert.setPositiveButton(positivetext,
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                //cache clear

                            }
                        });
            } else {
                dlgAlert.setCancelable(true);
            }
            if (negativetext != null) {

                dlgAlert.setNegativeButton(negativetext, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

            }
            dlgAlert.create().show();
        }
    }

  /*  public static void displaySnackBar(Context context, String msg, int snackColor){
        int color = snackColor == 0 ? R.color.green : snackColor;
        SnackbarManager.show(
                Snackbar.with(context).text(msg)
                        .actionLabel("OK")
                        .actionColorResource("#ffffff")
                        .color(ContextCompat.getColor(context, color))
                        .textTypeface(Typeface.create("sans-serif-medium", 0))
                        .type(SnackbarType.MULTI_LINE)
                        .actionListener(new ActionClickListener() {
                            @Override
                            public void onActionClicked(com.nispok.snackbar.Snackbar snackbar) {

                            }
                        })
        );
    }
*/

}
