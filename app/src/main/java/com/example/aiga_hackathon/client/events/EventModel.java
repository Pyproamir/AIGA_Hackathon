package com.example.aiga_hackathon.client.events;

public class EventModel {
    public int imageUrlEvent;
    public boolean isLive;
    public boolean isRegisterOpen;
    public String nameEvent;

    public EventModel(int imageUrlEvent, boolean isLive, boolean isRegisterOpen, String nameEvent) {
        this.imageUrlEvent = imageUrlEvent;
        this.isLive = isLive;
        this.isRegisterOpen = isRegisterOpen;
        this.nameEvent = nameEvent;
    }

    public int getImageUrlEvent() {
        return imageUrlEvent;
    }

    public void setImageUrlEvent(int imageUrlEvent) {
        this.imageUrlEvent = imageUrlEvent;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public boolean isRegisterOpen() {
        return isRegisterOpen;
    }

    public void setRegisterOpen(boolean registerOpen) {
        isRegisterOpen = registerOpen;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }
}
