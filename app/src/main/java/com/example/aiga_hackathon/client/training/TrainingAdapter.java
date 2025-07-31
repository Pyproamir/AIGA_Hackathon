package com.example.aiga_hackathon.client.training;

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
    private int layoutSpinner;

    private int layoutDropDown;
    private List<TrainingItem> states;

    public TrainingAdapter(Context context, int resourceSpinner, int resourceDropDown, List<TrainingItem> states) {
        super(context, resourceSpinner, states);
        this.states = states;
        layoutSpinner = resourceSpinner;
        layoutDropDown = resourceDropDown;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layoutSpinner, parent, false);

        TextView textView = view.findViewById(R.id.spinner_text_training);
        TrainingItem trainingItem = states.get(position);

        textView.setText(trainingItem.getString());

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layoutDropDown, parent, false);

        TextView textView = view.findViewById(R.id.drop_down_text_training);
        TrainingItem trainingItem = states.get(position);

        textView.setText(trainingItem.getString());

        return view;
    }
}
