package com.rachedisarfaraz.project4a;

import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<MyNotification> mDataset = new ArrayList<MyNotification>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        IntentFilter intentFilter = new IntentFilter(BierUpdate.BIERS_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BierUpdate(), intentFilter);

        MyIntentService2.startActionGetJson(this, "test", "tesst");

        //The recyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //mRecyclerView.setHasFixedSize(true);

        //The Layout Manager to handle the view
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //The adapter to handle data and bind it
        for (int i =0; i < 10; i++){
            MyNotification notification = new MyNotification("Notificaiton n°"+i, "Lorem Ipsum"+i);
            mDataset.add(notification);
        }

        mAdapter = new MyAdapter(this.mDataset);
        mRecyclerView.setAdapter(mAdapter);

        /*getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.list, new BlankFragment())
                .commit()
        ;*/
    }
}
