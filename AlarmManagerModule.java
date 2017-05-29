package com.wakeupify;

// Android
import android.widget.Toast;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import java.util.Calendar;

// React
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;


public class AlarmManagerModule extends ReactContextBaseJavaModule {

  // Constructor
  public AlarmManagerModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }


  @Override
  public String getName() {
    return "AlarmManager";
  }

  @ReactMethod
  public void setAlarm() {
       Context context = getReactApplicationContext();

       // Create and package up the intent
       Intent intent = new Intent(context, AlarmReceiver.class);
       PendingIntent pintent = PendingIntent.getBroadcast(context, 0, intent, 0);

       // Set the alarm
       AlarmManager alarmManager = (AlarmManager) getReactApplicationContext().getSystemService(Context.ALARM_SERVICE);
       alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
               + (5 * 1000), pintent);

       Toast.makeText(getReactApplicationContext(), "Alarm set..",Toast.LENGTH_LONG).show();
   }

}
