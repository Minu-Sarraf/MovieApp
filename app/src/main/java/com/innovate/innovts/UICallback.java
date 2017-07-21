package com.innovate.innovts;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by User on 7/7/2016.
 */
public interface UICallback {
    void update(double urltype, double uri, String address);
    void refresh_interface(String b, int a);

    void getName(List<String> name);

    // void updatefcm(String urltype, ArrayList<Notification_history.ResponseBean> responseBeans);
}
