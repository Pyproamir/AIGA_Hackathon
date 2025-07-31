package com.example.aiga_hackathon.client.drop_down_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aiga_hackathon.R;

import java.util.List;

public class TrainingAdapter extends ArrayAdapter<TrainingItem>{
    private LayoutInflater inflater;
    private int layout;
    private List<TrainingItem> states;

    public TrainingAdapter(Context context, int resource, List<TrainingItem> states) {
        super(context, resource, states);
        this.states = states;
        layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        TextView textView = view.findViewById(R.id.drop_down_text_training);
        TrainingItem trainingItem = states.get(position);

        textView.setText(trainingItem.getString());

        return view;
    }
}
