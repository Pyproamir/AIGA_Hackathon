package com.example.aiga_hackathon.client;

import com.example.aiga_hackathon.client.events.EventModel;
import com.example.aiga_hackathon.client.profile.User.UserModel;
import com.example.aiga_hackathon.client.trainer_list.TrainerListModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("trainer_list")
    Call<List<TrainerListModel>> getTrainers();
    @GET("events")
    Call<List<EventModel>> getEvents();

    @GET("/getUserByName")
    Call<UserModel> getUser(@Query("name") String email);

    @POST("/api/v1/auth/register")
    Call<Map<String, Object>> register(@Body Map<String, String> request);

    @POST("/api/v1/auth/login")
    Call<Map<String, Object>> login(@Body Map<String, String> request);

    @POST("/api/v1/chat")
    Call<Map<String, Object>> sendMessage(@Header("Authorization") String auth, @Body Map<String, Object> request);

}