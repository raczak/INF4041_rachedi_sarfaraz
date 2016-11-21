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

public class PetUpdate extends BroadcastReceiver {
    public static final String PET_UPDATE = "com.rachedisarfaraz.project4a.PET_UPDATE";
    final NotificationManager mNotification;
    private final static int NOTIFICATION_ID = 001;
    private OnRefreshListener tabListener;
    private OnRefreshListener tab2Listener;
    private OnRefreshListener tab3Listener;
    //private RecyclerView rc;


    public PetUpdate(Context context, OnRefreshListener tabListener, OnRefreshListener tab2Listener, OnRefreshListener tab3Listener) {
        mNotification = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        this.tabListener = tabListener;
        this.tab2Listener = tab2Listener;
        this.tab3Listener = tab3Listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //On met à jour le tableau json
        /*PetAdapter adapter = (PetAdapter) rc.getAdapter();
        ListActivity listActivity = (ListActivity) context;
        adapter.setNewBiere(listActivity.getBiersFromFile());*/

        Intent resultIntent = new Intent(context, MainActivity.class);
        PendingIntent resultPendingIntent =
            PendingIntent.getActivity(
                context,
                0,
                resultIntent,
                0 // Changer cette valeur à "FLAG_UPDATE_CURRENT" permet de décider de fermer
                    // la notificaiton celon besoin
        );

        tabListener.OnRefresh();
        tab2Listener.OnRefresh();
        tab3Listener.OnRefresh();

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_action_coffee)
                        .setContentTitle(context.getResources().getString(R.string.title_download_end))
                        .setContentText(context.getResources().getString(R.string.content_download_end))
                        .setAutoCancel(true)
                        .setContentIntent(resultPendingIntent);

        //On execute la notification qu'après avoir charger le contenu du json
        mNotification.notify(NOTIFICATION_ID, mBuilder.build());

        Log.d("OK Receiver", "Pokemon Recu !");

    }
}
