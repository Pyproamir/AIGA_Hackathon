package com.example.aiga_hackathon.client.profile.User;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.aiga_hackathon.client.ApiService;
import com.example.aiga_hackathon.client.Retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private ApiService apiService;

    public UserRepository(){
        apiService = Retrofit.getInstance();
    }
    public LiveData<UserModel> getUser(String name) {
        MutableLiveData<UserModel> userData = new MutableLiveData<>();
        apiService.getUser(name).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful()) userData.setValue(response.body());
                else Log.e("UserRepository", "Empty or error response: " + response.code());
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.e("UserRepository", "API failure: " + t.getMessage(), t);
                userData.setValue(null);
            }
        });
        return userData;
    }
}