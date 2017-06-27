package com.innovate.innovts;

import java.util.ArrayList;



/**
 * Created by User on 7/7/2016.
 */
public interface UICallback {
    void update(double urltype, double uri, String address);
    void refresh_interface(String b, int a);

   // void updatefcm(String urltype, ArrayList<Notification_history.ResponseBean> responseBeans);
}
