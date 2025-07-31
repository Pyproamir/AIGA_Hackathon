package com.example.aiga_hackathon.client.story_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aiga_hackathon.R;

public class StoryView extends LinearLayout {

    private TextView storyName;

    public StoryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public StoryView(Context context) {
        super(context);
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.story_view, this, true);

        storyName = findViewById(R.id.StoryName);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.StoryView);

        String name = a.getString(R.styleable.StoryView_Name);

        if (name != null) {
            storyName.setText(name);
        }

        a.recycle();
    }

    public void setStoryName(String name){
        storyName.setText(name);
    }
}

