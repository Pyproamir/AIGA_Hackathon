package com.example.aiga_hackathon.client.training;

public class TrainingItem {
    private String string;

    public TrainingItem(String newString){
        string = newString;
    }

    public String getString(){
        return string;
    }

    public void setString(String newString){
        string = newString;
    }
}
