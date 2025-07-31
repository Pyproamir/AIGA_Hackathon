package com.example.aiga_hackathon.client.drop_down_list;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aiga_hackathon.R;

public class DropDownListView extends LinearLayout {
    private TextView headerText;
    private ListView expandable;

    public DropDownListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.training_list_view, this, true);

        headerText = findViewById(R.id.header_text);
        expandable = (ListView)findViewById(R.id.expandable_content);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DropDownListView);
        String text = a.getString(R.styleable.DropDownListView_headerText);
        if (text != null) {
            headerText.setText(text);
        }
        a.recycle();

        findViewById(R.id.header).setOnClickListener(v -> {
            if (expandable.getVisibility() == GONE) {
                expandable.setVisibility(VISIBLE);
            } else {
                expandable.setVisibility(GONE);
            }
        });
    }

    public void SetAdapterForList(TrainingAdapter adapter){
        expandable.setAdapter(adapter);
    }
}
