package com.example.aiga_hackathon.client.profile.User;

import com.google.gson.annotations.SerializedName;

public class Achievements {
    @SerializedName("achievement")
    String achievement;

    @SerializedName("desc")
    String desc;

    @SerializedName("coins_num")
    int coins_num;
    public Achievements(String achievement, String desc, int coins_num) {
        this.achievement = achievement;
        this.desc = desc;
        this.coins_num = coins_num;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCoins_num() {
        return coins_num;
    }

    public void setCoins_num(int coins_num) {
        this.coins_num = coins_num;
    }
}
