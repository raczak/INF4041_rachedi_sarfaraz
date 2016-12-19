package com.rachedisarfaraz.project4a;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rachedisarfaraz.project4a.database.models.Pet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class Name : PetAdapter
 * This class handles data inserted into views
 * Methods :
 * -onCreateViewHolder: create new view
 * -onBindViewHolder: update view
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {
    private JSONArray pets;

    // Provide a suitable constructor (depends on the kind of dataset)
    public PetAdapter(JSONArray pets) {
        this.pets = pets;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView petName;
        public TextView mTextView2;

        public ViewHolder(View v) {
            super(v);
            petName = (TextView) v.findViewById(R.id.petName);
            //mTextView2 = (TextView) v.findViewById(R.id.text2);

        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // todo : On remplit les vues générées par le OnCreateViewHolder/ViewHolder
        try {
            JSONObject tab = pets.getJSONObject(2);
            String name = pets.getJSONObject(position).getString("name");
            Log.d("TAG_test", tab.getString("name"));
            Log.d("TAG_test", "Ca rentre");
            holder.petName.setText(name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //holder.mTextView2.setText(pets.get(position).text2);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return pets.length();
    }

    public void setNewPet () {

        //this.pets = petUpdated;
        notifyDataSetChanged();
    }
}

