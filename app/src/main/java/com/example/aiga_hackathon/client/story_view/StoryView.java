package com.example.aiga_hackathon.client.story_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.aiga_hackathon.R;

public class StoryView extends LinearLayout {

    private TextView storyName;

    private ImageView imagePfp;
    private FrameLayout storyLayout;
    private Context context;

    public StoryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs);
    }

    public StoryView(Context context) {
        super(context);
        this.context = context;
        init(null);
    }

    private void init(AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.story_view, this, true);

        storyName = findViewById(R.id.StoryName);
        imagePfp = findViewById(R.id.StoryPFP);
        storyLayout = findViewById(R.id.StoryLayout);

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

    public void setPfp(Drawable drawable){
        imagePfp.setImageDrawable(drawable);
    }

    public void setActive(Boolean active){
        if(active){
            storyLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.story_rectangle));
        }
        else{
            storyLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.story_inactive_rectangle));
        }
    }
}

