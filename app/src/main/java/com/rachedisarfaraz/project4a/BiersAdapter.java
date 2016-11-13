package com.rachedisarfaraz.project4a;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

class BiersAdapter extends RecyclerView.Adapter<BiersAdapter.ViewHolder> {
    private JSONArray biers;

    // Provide a suitable constructor (depends on the kind of dataset)
    public BiersAdapter(JSONArray biers) {
        this.biers = biers;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BiersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_bier_element, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name;
        public TextView mTextView2;

        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.rv_bier_element_name);
            //mTextView2 = (TextView) v.findViewById(R.id.text2);

        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // todo : On remplit les vues générées par le OnCreateViewHolder/ViewHolder
        try {
            holder.name.setText(biers.getJSONObject(position).getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //holder.mTextView2.setText(biers.get(position).text2);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return biers.length();
    }
}

