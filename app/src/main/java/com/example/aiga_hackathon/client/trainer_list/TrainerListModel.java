package com.example.aiga_hackathon.client.trainer_list;

import com.google.gson.annotations.SerializedName;

public class TrainerListModel {
    @SerializedName("imageUrl")
    public int imageUrl;

    @SerializedName("name")
    public String name;

    @SerializedName("group")
    public String group;

    @SerializedName("rating")
    public float rating;

    public TrainerListModel(int imageUrl, String name, String group, float rating) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.group = group;
        this.rating = rating;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
