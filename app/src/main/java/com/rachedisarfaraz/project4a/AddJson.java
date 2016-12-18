package com.rachedisarfaraz.project4a;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
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
 * Created by zakariarachedi on 18/12/2016.
 */

public class AddJson extends AsyncTask<File, Void, String> {
    private Exception exception;
    private String TAG = "Splash";
    private String urlTab1 = "http://pokeapi.co/api/v2/pokemon/";
    private String urlTab2 = "http://pokeapi.co/api/v2/pokemon/?offset=20";
    private String urlTab3 = "http://pokeapi.co/api/v2/pokemon/?offset=100";
    static File cache;

    protected String doInBackground(File... cache) {

        this.cache = cache[0];

        handleActionGetJson(urlTab1, "pokemon.json");
        handleActionGetJson(urlTab2, "pokemon2.json");
        handleActionGetJson(urlTab3, "pokemon3.json");

        return null;
    }

    private void handleActionGetJson(String url_tab, String fileName) {
        Log.d(TAG, "Service démarré !");

        URL url =null;

        try {
            url = new URL(url_tab);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            if (HttpsURLConnection.HTTP_OK == conn.getResponseCode()){
                copyInputStreamToFile(conn.getInputStream(),
                        new File(cache, fileName));
                Log.d(TAG, "Pokemon json downloaded !");

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    protected void onPostExecute(String feed) {

    }
}
