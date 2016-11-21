package com.rachedisarfaraz.project4a;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.rachedisarfaraz.project4a.database.DAO.PetDAO;
import com.rachedisarfaraz.project4a.database.models.Pet;
import com.rachedisarfaraz.project4a.tabs.PagerAdapter;
import com.rachedisarfaraz.project4a.tabs.fishList.FishFragment;
import com.rachedisarfaraz.project4a.tabs.chatList.CatFragment;
import com.rachedisarfaraz.project4a.tabs.dogList.DogFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {
    FloatingActionButton fabButton;

    //tab variables
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    //Url APi
    private String urlTab1 = "http://pokeapi.co/api/v2/pokemon/";
    private String urlTab2 = "http://pokeapi.co/api/v2/pokemon/?offset=20";
    private String urlTab3 = "http://pokeapi.co/api/v2/pokemon/?offset=100";
    private CatFragment tab1;
    private DogFragment tab2;
    private FishFragment tab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);

        //We load fragments
        tab1 = new CatFragment(getDataFromFile("pokemon.json"));
        tab2 = new DogFragment(getDataFromFile("pokemon2.json"));
        tab3 = new FishFragment(getDataFromFile("pokemon3.json"));

        //Setup and config IntentService
        IntentFilter intentFilter = new IntentFilter(PetUpdate.PET_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new PetUpdate(this, tab1, tab2, tab3), intentFilter);

        MyIntentService.startActionGetJson(this, urlTab1, "pokemon.json");
        MyIntentService.startActionGetJson(this, urlTab2, "pokemon2.json");
        MyIntentService.startActionGetJson(this, urlTab3, "pokemon3.json");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TextView tv_hw = (TextView) findViewById(R.id.tv_hello_word);

        //Setup of Fab button
        fabButton = (FloatingActionButton) findViewById(R.id.fab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //String now = DateUtils.formatDateTime(getApplicationContext(), (new Date()).getTime(), DateFormat.FULL);
        //tv_hw.setText(now);

        //Button nextAct = (Button) findViewById(R.id.btn_hello_world);

        /*nextAct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Next activity", Toast.LENGTH_SHORT).show();
                Intent nextAct =new Intent(MainActivity.this, ListActivity.class);
                startActivity(nextAct);
            }
        }); */

        //setup of the tabLayout

        //ImageView imageView = (ImageView) findViewById(R.id.post_author_photo);
        //Log.d(TAG, "poke Image : " + imageView);
        //imageView.setImageResource(R.drawable.p002);

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

                switch (tab.getPosition()) {
                    case 0:
                        tabLayout.setBackgroundColor(getColor(R.color.colorPrimary));
                        toolbar.setBackgroundColor(getColor(R.color.colorPrimary));
                        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                        //getWindow().setStatusBarColor(Color.TRANSPARENT);
                        fabButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorNormal)));
                        break;
                    case 1:
                        tabLayout.setBackgroundColor(getColor(R.color.colorBlue));
                        toolbar.setBackgroundColor(getColor(R.color.colorBlue));
                        window.setStatusBarColor(getResources().getColor(R.color.colorBlueDark));
                        fabButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorRare)));
                        break;
                    case 2:
                        tabLayout.setBackgroundColor(getColor(R.color.colorYellow));
                        toolbar.setBackgroundColor(getColor(R.color.colorYellow));
                        window.setStatusBarColor(getResources().getColor(R.color.colorYellowDark));
                        fabButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLegendary)));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        });

        //View hView =  navigationView.getHeaderView(0);
        //ImageView menuUserIcon = (ImageView) hView.findViewById(R.id.imageView);

        //ImageView menuUserIcon = (ImageView) findViewById(R.id.imageView);
        //Glide.with(MainActivity.this).load(mPhotoUrl).into(menuUserIcon);
        //Glide.with(this).load(loadUser.getmPhotoUrl()).into(menuUserIcon);
    }

    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(tab1, "Gen 1");
        adapter.addFragment(tab2, "Gen 2");
        adapter.addFragment(tab3, "Gen 3");
        viewPager.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);

        /*String hist = null;

        switch(id) {
            case R.id.action_new :
                hist = getResources().getString(R.string.toast_new);
                break;
            case R.id.action_edit :
                hist = getResources().getString(R.string.toast_edit);
                break;
            case R.id.action_delete :
                hist = getResources().getString(R.string.toast_delete);
                break;
            default:
        }

        Context context = getApplicationContext();
        Toast msg = Toast.makeText(context, hist, Toast.LENGTH_LONG);
        msg.setGravity(Gravity.CENTER, msg.getXOffset() / 2, msg.getYOffset() / 2);
        msg.show();*/
        
        return true;
    }

    public JSONArray getDataFromFile(String fileName) {
        try {
            InputStream is = new FileInputStream(getCacheDir() + "/" + fileName);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            JSONObject obj = new JSONObject(new String(buffer, "UTF-8"));
            return obj.getJSONArray("results"); //construction du tableau
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONArray();
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}