package com.rachedisarfaraz.project4a.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rachedisarfaraz.project4a.PetAdapter;
import com.rachedisarfaraz.project4a.R;
//import com.rachedisarfaraz.project4a.models.Pet;

import org.json.JSONArray;


public abstract class PetListFragment extends Fragment {

    private static final String TAG = "CatFragment";

    private RecyclerView.Adapter mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    public PetListFragment() {}

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_all_pet, container, false);

        //The recyclerView
        mRecycler = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        mRecycler.setHasFixedSize(true);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //The Layout Manager to handle the view, reverse layout
        mManager = new LinearLayoutManager(getActivity());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);

        //The adapter to handle data and bind it
        JSONArray data = getData();
        mAdapter = new PetAdapter(data);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public abstract JSONArray getData();
}