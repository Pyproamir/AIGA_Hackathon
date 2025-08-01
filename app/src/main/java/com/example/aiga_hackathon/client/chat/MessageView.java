package com.example.aiga_hackathon.client.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aiga_hackathon.R;

import java.sql.Time;

public class MessageView extends LinearLayout {
    private Context context;
    private TextView messageTextView;
    private TextView timeTextView;
    private LinearLayout messageBubble;
    private LinearLayout messageContainer;

    public MessageView(Context context, AttributeSet attr){
        super(context, attr);
        this.context = context;
        init();
    }

    private void init(){
        LayoutInflater.from(context).inflate(R.layout.message_view, this, true);

        messageTextView = findViewById(R.id.MessageText);
        timeTextView = findViewById(R.id.MessageTime);
        messageBubble = findViewById(R.id.MessageBubble);
        messageContainer = findViewById(R.id.MessageContainer);
    }

    public void setMessageText(String text){
        messageTextView.setText(text);
    }

    public void setMessageTime(Time time){
        timeTextView.setText(time.toString().substring(0, 5));
    }

    public void setIsAuthor(Boolean isAuthor){
        LayoutParams layoutParams = (LayoutParams) messageBubble.getLayoutParams();
        if (isAuthor) {
            messageBubble.setBackgroundResource(R.drawable.bg_message_user);
            layoutParams.gravity = Gravity.END;
        } else {
            messageBubble.setBackgroundResource(R.drawable.bg_message_other);
            layoutParams.gravity = Gravity.START;
        }
        messageBubble.setLayoutParams(layoutParams);
    }
}
