package com.rachedisarfaraz.project4a.tabs.chatList;

import android.util.Log;

import com.rachedisarfaraz.project4a.MyIntentService;
import com.rachedisarfaraz.project4a.tabs.PetListFragment;

import org.json.JSONArray;

public class CatFragment extends PetListFragment {
    JSONArray data;

    public CatFragment() {
    }

    public CatFragment(JSONArray data) {
        this.data = data;
    }

    @Override
    public JSONArray getData() {
        return data;
    }

    @Override
    public void OnRefresh() {
        MyIntentService.startActionGetJson(getContext(), "http://pokeapi.co/api/v2/pokemon/", "pokemon.json");
        Log.d("CatFragment", "Lance le intentService");
    }
}