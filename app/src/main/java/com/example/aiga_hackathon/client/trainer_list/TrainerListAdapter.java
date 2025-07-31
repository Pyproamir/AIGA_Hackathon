package com.example.aiga_hackathon.client.trainer_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aiga_hackathon.R;
import com.example.aiga_hackathon.client.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class TrainerListAdapter extends RecyclerView.Adapter<TrainerListViewHolder> {

    private HomeFragment context; // Context -> HomeFragment
    private List<TrainerListModel> trainerList;
    private TrainerListViewModel trainerListViewModel;

    public TrainerListAdapter(HomeFragment context, List<TrainerListModel> trainerList, TrainerListViewModel trainerListViewModel) { // Context -> HomeFragment
        this.context = context;
        this.trainerList = trainerList;
        this.trainerListViewModel = trainerListViewModel;
    }

    @NonNull
    @Override
    public TrainerListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trainer_list_item, parent, false);
        return new TrainerListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainerListViewHolder holder, int position) {
        TrainerListModel model = trainerList.get(position);
        holder.name.setText(model.getName());
        holder.group.setText(model.getGroup());
        holder.rating.setText(String.valueOf(model.getRating()));
        holder.profile.setImageResource(model.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return trainerList.size();
    }

    public void setTrainerList(List<TrainerListModel> trainer){
        this.trainerList = new ArrayList<>(trainer);
        notifyDataSetChanged();
    }

}

class TrainerListViewHolder extends RecyclerView.ViewHolder{
    ImageView profile;
    TextView name, group, rating;


    public TrainerListViewHolder(@NonNull View itemView) {
        super(itemView);
        profile = itemView.findViewById(R.id.trainer_list_ic);
        name = itemView.findViewById(R.id.trainer_list_name);
        group = itemView.findViewById(R.id.trainer_list_group);
        rating = itemView.findViewById(R.id.traner_list_rating);
    }
}