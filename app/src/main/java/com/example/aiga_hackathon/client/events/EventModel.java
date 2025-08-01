package com.example.aiga_hackathon.client.events;

public class EventModel {
    public String imageUrlEvent;
    public boolean isLive;
    public boolean isRegisterOpen;
    public String nameEvent;

    public EventModel(String imageUrlEvent, boolean isLive, boolean isRegisterOpen, String nameEvent) {
        this.imageUrlEvent = imageUrlEvent;
        this.isLive = isLive;
        this.isRegisterOpen = isRegisterOpen;
        this.nameEvent = nameEvent;
    }

    public String getImageUrlEvent() {
        return imageUrlEvent;
    }

    public void setImageUrlEvent(String imageUrlEvent) {
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
