package com.rachedisarfaraz.project4a;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String getJson = "com.rachedisarfaraz.project4a.action.getJson";
    private String TAG = "ServiceIntent";

    // TODO: Rename parameters
    private static final String EXTRA_TAB = "com.rachedisarfaraz.project4a.extra.PARAM1";
    private static final String EXTRA_TAB2 = "com.rachedisarfaraz.project4a.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    //Cette action est appelée d'abord par l'activité "ListActivity" pour construire l'intent
    //Contenant les paramètres et allant vers le IntentService. La particularité est que ceci
    // ce fait dans le futur service appelé plutot que directement dans l'activité
    public static void startActionGetJson(Context context, String url_tab, String fileName) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(getJson);
        intent.putExtra(EXTRA_TAB, url_tab);
        intent.putExtra(EXTRA_TAB2, fileName);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String url_tab = intent.getStringExtra(EXTRA_TAB);
            final String fileName = intent.getStringExtra(EXTRA_TAB2);
            handleActionGetJson(url_tab, fileName);
        }
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionGetJson(String url_tab, String fileName) {
        Log.d(TAG, "Service démarré !");

        URL url =null;

        try {
            url = new URL(url_tab);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            if (HttpsURLConnection.HTTP_OK == conn.getResponseCode()){
                copyInputStreamToFile(conn.getInputStream(),
                        new File(getCacheDir(), fileName));
                Log.d(TAG, "Pokemon json downloaded !");

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Intent broadcastIntent = new Intent();
        //broadcastIntent.setAction(PetUpdate)
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(PetUpdate.PET_UPDATE));
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    private void copyInputStreamToFile(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len=in.read(buf))>0) {
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}