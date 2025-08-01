package com.example.aiga_hackathon.client.chat;

import java.sql.Time;

public class MessageItem {
    private String message;
    private Time time;
    private Boolean authorIsUser;

    public MessageItem(String message, Time time, Boolean authorIsUser){
        this.message = message;
        this.time = time;
        this.authorIsUser = authorIsUser;
    }

    public Boolean getAuthorIsUser() {
        return authorIsUser;
    }

    public String getMessage() {
        return message;
    }

    public Time getTime() {
        return time;
    }
}
