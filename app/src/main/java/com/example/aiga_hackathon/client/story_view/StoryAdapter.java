package com.example.aiga_hackathon.client.story_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aiga_hackathon.R;

import java.util.List;

public class StoryAdapter extends ArrayAdapter<StoryItem> {
    private LayoutInflater inflater;
    private int layout;
    private List<StoryItem> states;

    public StoryAdapter(Context context, int resource, List<StoryItem> states) {
        super(context, resource, states);
        this.states = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        StoryItem storyItem = states.get(position);

        TextView nameView = view.findViewById(R.id.StoryName);
        Icon

        return view;
    }

}
