package com.example.aiga_hackathon.client.story_view;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

public class StoryItem {
    private String name;
    private Drawable pfp;

    public StoryItem(Context context, String name, int drawableResId) {
        this.name = name;
        this.pfp = ContextCompat.getDrawable(context, drawableResId);
    }

    public String getName() {return name;}

    public Drawable getPfp() {return pfp;}
}
