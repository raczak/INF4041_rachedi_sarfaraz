package com.rachedisarfaraz.project4a;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;


/*
* Class name : BierUpdate
* Class of bieres of the project
* Methods :
* -BierUpdate : Constructor, notification system enabler.
* -onReceive : Notifications settings on receiving data.
*/
public class BierUpdate extends BroadcastReceiver {
    public static final String BIERS_UPDATE = "com.rachedisarfaraz.project4a.BIERS_UPDATE";
    final NotificationManager mNotification;
    private final static int NOTIFICATION_ID = 001;

    public BierUpdate(Context context) {
        mNotification = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent resultIntent = new Intent(context, MainActivity.class);
        PendingIntent resultPendingIntent =
            PendingIntent.getActivity(
                context,
                0,
                resultIntent,
                0
        );

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_action_coffee)
                        .setContentTitle(context.getResources().getString(R.string.title_download_end))
                        .setContentText(context.getResources().getString(R.string.content_download_end))
                        .setAutoCancel(true)
                        .setContentIntent(resultPendingIntent);

        mNotification.notify(NOTIFICATION_ID, mBuilder.build());

        Log.d("OK Receiver", "Bieres Recu !");

    }
}
