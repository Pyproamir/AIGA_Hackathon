package com.example.aiga_hackathon.client.chat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aiga_hackathon.R;

public class ChatView extends LinearLayout {
    private Context context;

    private ImageView backButton;
    private ImageView chatPFP;
    private TextView userName;
    RecyclerView messagesRecyclerView;

    public ChatView(Context context, AttributeSet attr){
        super(context, attr);
        this.context = context;
        init();
    }

    private void init(){
        LayoutInflater.from(context).inflate(R.layout.chat_view, this, true);

        backButton = findViewById(R.id.ChatBackButton);
        chatPFP = findViewById(R.id.ChatPFP);
        userName = findViewById(R.id.ChatUserName);
        messagesRecyclerView = findViewById(R.id.ChatMessageRecycleView);

        messagesRecyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    public void setBackButtonClickListener(View.OnClickListener onClickListener){
        backButton.setOnClickListener(onClickListener);
    }

    public void setChatPFP(Drawable drawable){
        chatPFP.setImageDrawable(drawable);
    }

    public void setUserName(String name){
        userName.setText(name);
    }

    public void setMessagesRecyclerAdapter(RecyclerView.Adapter adapter){
        messagesRecyclerView.setAdapter(adapter);
    }
}
