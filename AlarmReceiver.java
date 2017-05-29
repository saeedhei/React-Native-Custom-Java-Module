package com.wakeupify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;

/**
 * Created by z on 5/28/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
      Toast.makeText(context, "Alarm Ran....", Toast.LENGTH_LONG).show();
    }
}
