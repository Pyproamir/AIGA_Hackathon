package com.example.aiga_hackathon.client.story_view;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

public class StoryItem {
    String name;
    Drawable pfp;

    public StoryItem(Context context, String name, int drawableResId) {
        this.name = name;
        this.pfp = ContextCompat.getDrawable(context, drawableResId);
    }
}
