package com.example.aiga_hackathon.client.drop_down_list;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aiga_hackathon.R;

public class DropDownListView extends LinearLayout {
    private TextView headerText;
    private ListView expandable;

    private ImageView icon;

    public DropDownListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.drop_down_list_view, this, true);

        headerText = findViewById(R.id.header_text);
        expandable = findViewById(R.id.expandable_content);
        icon = findViewById(R.id.triangle_icon);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DropDownListView);
        String text = a.getString(R.styleable.DropDownListView_headerText);
        if (text != null) {
            headerText.setText(text);
        }
        a.recycle();

        findViewById(R.id.header).setOnClickListener(v -> {
            if (expandable.getVisibility() == GONE) {
                expandable.setVisibility(VISIBLE);
                icon.setRotation(180);
            } else {
                icon.setRotation(0);
                expandable.setVisibility(GONE);
            }
        });
    }


    public <T> void SetAdapterForList(ArrayAdapter<T> adapter){
        expandable.setAdapter(adapter);
    }
}
