package com.rachedisarfaraz.project4a;

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

        //The recyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //mRecyclerView.setHasFixedSize(true);

        //The Layout Manager to handle the view
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //The adapter to handle data and bind it
        MyNotification notif = new MyNotification("test1", "test1bis");
        MyNotification notif2 = new MyNotification("test2", "test2bis");
        MyNotification notif3 = new MyNotification("test3", "test3bis");
        MyNotification notif4 = new MyNotification("test4", "test4bis");
        MyNotification notif5 = new MyNotification("test5", "test5bis");

        mDataset.add(notif);
        mDataset.add(notif2);
        mDataset.add(notif3);
        mDataset.add(notif4);
        mDataset.add(notif5);

        mAdapter = new MyAdapter(this.mDataset);
        mRecyclerView.setAdapter(mAdapter);

        /*getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.list, new BlankFragment())
                .commit()
        ;*/
    }
}
