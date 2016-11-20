package com.rachedisarfaraz.project4a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

/*
* Class name : BiersAdapter
* Class of bieres of the project
* Methods :
* -BiersAdapter : Constructor, return biers.
* -onCreateViewHolder : Create new views.
* -ViewHolder : Provide a reference to the views for each data item.
* -onBindViewHolder : Replace the contents of a view
* -getItemCount : Return size of biers.
*/
class BiersAdapter extends RecyclerView.Adapter<BiersAdapter.ViewHolder> {
    private JSONArray biers;

    public BiersAdapter(JSONArray biers) {
        this.biers = biers;
    }

    @Override
    public BiersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_bier_element, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView mTextView2;

        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.rv_bier_element_name);

        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            holder.name.setText(biers.getJSONObject(position).getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return biers.length();
    }
}

