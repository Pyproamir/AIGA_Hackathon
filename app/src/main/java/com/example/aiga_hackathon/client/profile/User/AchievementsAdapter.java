package com.example.aiga_hackathon.client.profile.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aiga_hackathon.R;

import java.util.List;

class AchievementsAdapter extends RecyclerView.Adapter<AchievementsAdapter.AchievementViewHolder> {

    private List<Achievements> achievementsList;
    private Context context;

    public AchievementsAdapter(Context context, List<Achievements> achievementsList) {
        this.context = context;
        this.achievementsList = achievementsList;
    }

    @NonNull
    @Override
    public AchievementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.achievements_item, parent, false);
        return new AchievementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AchievementViewHolder holder, int position) {
        Achievements achievement = achievementsList.get(position);
        holder.achievementText.setText(achievement.getAchievement());
        holder.descText.setText(achievement.getDesc());
        holder.coinsText.setText(String.valueOf(achievement.getCoins_num()));
    }

    @Override
    public int getItemCount() {
        return achievementsList.size();
    }

    static class AchievementViewHolder extends RecyclerView.ViewHolder {

        TextView achievementText, descText, coinsText;

        public AchievementViewHolder(@NonNull View itemView) {
            super(itemView);
            achievementText = itemView.findViewById(R.id.tx_achievements_name);
            descText = itemView.findViewById(R.id.tx_achievements_desc);
            coinsText = itemView.findViewById(R.id.tx_achievements_bonuses);
        }
    }
}