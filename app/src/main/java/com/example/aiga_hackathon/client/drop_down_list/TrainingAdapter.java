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

        TrainingItem trainingItem = states.get(position);

        TextView trainingType = view.findViewById(R.id.training_item_training_type);
        trainingType.setText(trainingType.getText() + trainingItem.getTrainingType());

        TextView trainer = view.findViewById(R.id.training_item_trainer);
        trainer.setText(trainer.getText() + trainingItem.getTrainer());

        TextView date = view.findViewById(R.id.training_item_date);
        date.setText(date.getText() + trainingItem.getDate());

        TextView time = view.findViewById(R.id.training_item_time);
        time.setText(time.getText() + trainingItem.getTime());

        TextView location = view.findViewById(R.id.training_item_location);
        location.setText(location.getText() + trainingItem.getLocation());
        return view;
    }
}
