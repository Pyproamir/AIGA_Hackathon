package com.example.aiga_hackathon.client.trainer_list;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.aiga_hackathon.client.ApiService;
import com.example.aiga_hackathon.client.Retrofit;

import java.util.List;

import retrofit2.Callback;

import retrofit2.Call;
import retrofit2.Response;

public class TrainerListViewModel extends ViewModel {
    private MutableLiveData<List<TrainerListModel>> trainers;
    private ApiService api = Retrofit.getInstance();

    public LiveData<List<TrainerListModel>> getTrainers() {
        if (trainers == null) {
            trainers = new MutableLiveData<>();
            loadTrainers();
        }
        return trainers;
    }

    private void loadTrainers() {
        api.getTrainers().enqueue(new Callback<List<TrainerListModel>>() {
            @Override
            public void onResponse(Call<List<TrainerListModel>> call, Response<List<TrainerListModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    trainers.postValue(response.body());
                } else {
                    Log.e("TrainerListViewModel", "Empty or error response: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<TrainerListModel>> call, Throwable t) {
                Log.e("TrainerViewModel", "API failure: " + t.getMessage(), t);
            }
        });
    }
}
