package com.mbm.ftn.mbm.utils;

/**
 * Created by Milos on 6/18/2017.
 */

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.mbm.ftn.mbm.R;

public class ProximityActivity extends Activity {

    String notificationTitle;
    String notificationContent;
    String tickerMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        boolean proximity_entering = getIntent().getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING, true);

        double lat = getIntent().getDoubleExtra("lat", 0);

        double lng = getIntent().getDoubleExtra("lng", 0);

        //String strLocation = Double.toString(lat) + "," + Double.toString(lng);

        if (proximity_entering) {
            Toast.makeText(getBaseContext(), "Dolazite na željenu lokaciju", Toast.LENGTH_LONG).show();
            notificationTitle = "Obaveštenje";
            notificationContent = "Došli ste na željenu lokaciju";
            tickerMessage = "Došli ste na željenu lokaciju";
        } else {
            Toast.makeText(getBaseContext(), "Napuštate na željenu lokaciju", Toast.LENGTH_LONG).show();
            notificationTitle = "Obaveštenje";
            notificationContent = "Napustili ste na željenu lokaciju";
            tickerMessage = "Napustili ste na željenu lokaciju";
        }

        Intent notificationIntent = new Intent(getApplicationContext(), NotificationView.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        /** Adding content to the notificationIntent, which will be displayed on
         * viewing the notification
         */
        notificationIntent.putExtra("content", notificationContent);

        /** This is needed to make this intent different from its previous intents */
        notificationIntent.setData(Uri.parse("tel:/" + (int) System.currentTimeMillis()));

        /** Creating different tasks for each notification. See the flag Intent.FLAG_ACTIVITY_NEW_TASK */
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, 0);

        /** Getting the System service NotificationManager */
        NotificationManager nManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        /** Configuring notification builder to create a notification */
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext())
                .setWhen(System.currentTimeMillis())
                .setContentText(notificationContent)
                .setContentTitle(notificationTitle)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setTicker(tickerMessage)
                .setContentIntent(pendingIntent)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

        /** Creating a notification from the notification builder */
        Notification notification = notificationBuilder.build();

        /** Sending the notification to system.
         * The first argument ensures that each notification is having a unique id
         * If two notifications share same notification id, then the last notification replaces the first notification
         * */
        nManager.notify((int) System.currentTimeMillis(), notification);

        /** Finishes the execution of this activity */
        finish();
    }
}