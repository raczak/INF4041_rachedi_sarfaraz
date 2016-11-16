package com.rachedisarfaraz.project4a.tabs.chatList;

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
}