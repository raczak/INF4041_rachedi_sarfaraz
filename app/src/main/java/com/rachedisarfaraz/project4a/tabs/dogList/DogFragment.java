package com.rachedisarfaraz.project4a.tabs.dogList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rachedisarfaraz.project4a.MyIntentService;
import com.rachedisarfaraz.project4a.R;
import com.rachedisarfaraz.project4a.tabs.PetListFragment;

import org.json.JSONArray;

public class DogFragment extends PetListFragment {

    JSONArray data;

    public DogFragment() {
    }

    public DogFragment(JSONArray data) {
        this.data = data;
    }

    @Override
    public JSONArray getData() {
        Log.d("Dog Fragment", "getData");
        return data;
    }

    @Override
    public void OnRefresh() {
        //MyIntentService.startActionGetJson(getContext(), "http://pokeapi.co/api/v2/pokemon/?offset=20", "pokemon2.json");
    }
}