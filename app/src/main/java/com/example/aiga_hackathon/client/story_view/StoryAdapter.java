package com.example.aiga_hackathon.client.story_view;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aiga_hackathon.R;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {
    public interface OnStoryClickListener{
        void onStoryClick(StoryItem storyItem, int position);
    }
    private final OnStoryClickListener onStoryClickListener;
    private List<StoryItem> storyItems;
    private Context context;



    public StoryAdapter(Context context, List<StoryItem> storyItems, OnStoryClickListener onStoryClickListener) {
        this.context = context;
        this.storyItems = storyItems;
        this.onStoryClickListener = onStoryClickListener;
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

        if(position == 0){
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) holder.storyView.getLayoutParams();
            params.setMarginStart((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    24, context.getResources().getDisplayMetrics()));
            holder.storyView.setLayoutParams(params);
        }

        holder.storyView.setStoryName(item.getName());
        holder.storyView.setPfp(item.getPfp());
        holder.storyView.setActive(item.getActive());

        holder.storyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStoryClickListener.onStoryClick(item, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return storyItems.size();
    }

    public static class StoryViewHolder extends RecyclerView.ViewHolder {
        public StoryView storyView;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            storyView = itemView.findViewById(R.id.StoryView);
        }
    }
}

