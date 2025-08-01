package com.example.aiga_hackathon.client.drop_down_list.chats;

import android.graphics.drawable.Drawable;

public class ChatItem {
    public ChatItem(Drawable pfp, String userName, String message, String numberOfNewMessages, String dateLastMessage){
        this.pfp = pfp;
        this.userName = userName;
        this.message = message;
        this.numberOfNewMessages = numberOfNewMessages;
        this.dateLastMessageArrive = dateLastMessage;
    }

    public Drawable pfp;
    public String userName;
    public String message;
    public String numberOfNewMessages;
    public String dateLastMessageArrive;
}
