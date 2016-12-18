package com.rachedisarfaraz.project4a.tabs.fishList;

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

public class FishFragment extends PetListFragment {

    JSONArray data;

    public FishFragment() {
    }

    public FishFragment(JSONArray data) {
        this.data = data;
    }

    @Override
    public JSONArray getData() {
        Log.d("Fish Fragment", "getData");
        return data;
    }

    @Override
    public void OnRefresh() {
        //MyIntentService.startActionGetJson(getContext(), "http://pokeapi.co/api/v2/pokemon/?offset=100", "pokemon3.json");
    }
}
