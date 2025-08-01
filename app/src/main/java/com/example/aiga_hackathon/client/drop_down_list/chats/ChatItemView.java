package com.example.aiga_hackathon.client.drop_down_list.chats;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.aiga_hackathon.R;

public class ChatItemView extends LinearLayout {
    ImageView pfpImageView;
    TextView userNameTextView;
    TextView messageTextView;
    TextView numberOfNewMessagesTextView;
    TextView dateLastMessageArriveTextView;
    CardView cardView;

    public ChatItemView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.chat_item_view, this, true);

        pfpImageView = findViewById(R.id.ChatItemPFP);
        userNameTextView = findViewById(R.id.ChatItemUserName);
        messageTextView = findViewById(R.id.ChatItemMessage);
        numberOfNewMessagesTextView = findViewById(R.id.ChatItemNumberOfNewMessages);
        dateLastMessageArriveTextView = findViewById(R.id.ChatItemDateLastMessageArrive);
        cardView = findViewById(R.id.ChatItemCard);
    }

    public void setPFP(Drawable drawable){ pfpImageView.setImageDrawable(drawable); }

    public void setUserName(String userName){ userNameTextView.setText(userName); }

    public void setMessage(String message){ messageTextView.setText(message); }

    public void setNumberOfNewMessagesTextView(String numberMessages){
        numberOfNewMessagesTextView.setText(numberMessages);
        if(numberMessages.equals("0")){
            cardView.setVisibility(ChatItemView.GONE);
            numberOfNewMessagesTextView.setVisibility(ChatItemView.GONE);
        }
    }

    public void setDateLastMessageArriveTextView(String date){
        dateLastMessageArriveTextView.setText(date);
    }
}
