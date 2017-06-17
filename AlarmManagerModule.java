// package com.yourpackagenamehere;

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

  /**
  * Annotating this with @ReactMethod makes the setAlarm method available in React Native
  */
  @ReactMethod
  public void setAlarm(int hour, int minute, int id) {

       Context context = getReactApplicationContext();
 
       Intent intent = new Intent(context, AlarmReceiver.class);
       PendingIntent pintent = PendingIntent.getBroadcast(context, id, intent, 0);

       Calendar calendar = Calendar.getInstance();
       calendar.set(Calendar.HOUR_OF_DAY, hour);
       calendar.set(Calendar.MINUTE, minute);
       calendar.set(Calendar.SECOND, 0);

       AlarmManager alarmManager = (AlarmManager) getReactApplicationContext().getSystemService(Context.ALARM_SERVICE);
       alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pintent);

       // Will automatically launch a Toast on the Android Device
       Toast.makeText(context, "Alarm set!",Toast.LENGTH_LONG).show();
   }

}
