package com.example.aiga_hackathon.client.drop_down_list;

public class TrainingItem {
    private String trainingType;
    private String trainer;
    private String date;
    private String time;
    private String location;

    public TrainingItem(String trainingType, String trainer, String date, String time, String location){
        this.trainingType = trainingType;
        this.trainer = trainer;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public String getTrainingType(){ return trainingType; }

    public String getTrainer(){ return trainer; }

    public String getDate(){ return date; }

    public String getTime(){ return time; }

    public String getLocation(){ return location; }


}
