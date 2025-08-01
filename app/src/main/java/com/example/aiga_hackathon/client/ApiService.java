package com.example.aiga_hackathon.client;

import com.example.aiga_hackathon.client.events.EventModel;
import com.example.aiga_hackathon.client.profile.User.UserModel;
import com.example.aiga_hackathon.client.trainer_list.TrainerListModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("trainer_list")
    Call<List<TrainerListModel>> getTrainers();
    @GET("events")
    Call<List<EventModel>> getEvents();

    @GET("/getUserByName")
    Call<UserModel> getUser(@Query("name") String email);

}