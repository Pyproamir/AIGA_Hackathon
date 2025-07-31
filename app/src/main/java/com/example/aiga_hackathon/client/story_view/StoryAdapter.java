package com.example.aiga_hackathon.client.story_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aiga_hackathon.R;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {
    private List<StoryItem> storyItems;
    private Context context;

    public StoryAdapter(Context context, List<StoryItem> storyItems) {
        this.context = context;
        this.storyItems = storyItems;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate a container layout that holds the StoryView (e.g., item_story.xml)
        View view = LayoutInflater.from(context).inflate(R.layout.story_item, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        StoryItem item = storyItems.get(position);
        holder.storyView.setStoryName(item.getName());
        holder.storyView.setPfp(item.getPfp());
    }

    @Override
    public int getItemCount() {
        return storyItems.size();
    }

    public static class StoryViewHolder extends RecyclerView.ViewHolder {
        public StoryView storyView;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            storyView = itemView.findViewById(R.id.StoryView); // assumes R.id.StoryView is inside item_story.xml
        }
    }
}

