package com.rachedisarfaraz.project4a;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

public class BierUpdate extends BroadcastReceiver {
    public static final String BIERS_UPDATE = "com.rachedisarfaraz.project4a .BIERS_UPDATE";
    final NotificationManager mNotification = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    public BierUpdate() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving an Intent broadcast.

        Intent resultIntent = new Intent(context, ListActivity.class);
        PendingIntent resultPendingIntent =
            PendingIntent.getActivity(
                context,
                0,
                resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );


        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_announcement)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!")
                        .setContentIntent(resultPendingIntent);
        mNotification.notify(NOTIFICATION_ID, builder.build());

        Log.d("OK Receiver", "Bieres Recu !");

    }
}
