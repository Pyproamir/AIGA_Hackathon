package com.example.aiga_hackathon.client.profile.User;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserModel {
    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;
    @SerializedName("user_image")
    private String user_image;

    @SerializedName("birthday")
    private String birthday;

    @SerializedName("sport_type")
    private String sport_type;

    @SerializedName("phoneNumber")
    private String phoneNumber;

    @SerializedName("achievements")
    private List<Achievements> achievements;

    public UserModel(String name, String email, String password, String birthday,  String sport_type, String phoneNumber, String user_image, List<Achievements> achievements) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.sport_type = sport_type;
        this.phoneNumber = phoneNumber;
        this.achievements = achievements;
        this.birthday = birthday;
        this.user_image = user_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSport_type() {
        return sport_type;
    }

    public void setSport_type(String sport_type) {
        this.sport_type = sport_type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Achievements> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievements> achievements) {
        this.achievements = achievements;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }
}
