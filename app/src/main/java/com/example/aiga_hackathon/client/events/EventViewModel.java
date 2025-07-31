package com.example.aiga_hackathon.client.events;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.aiga_hackathon.client.ApiService;
import com.example.aiga_hackathon.client.Retrofit;
import com.example.aiga_hackathon.client.trainer_list.TrainerListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventViewModel extends ViewModel {
    private MutableLiveData<List<EventModel>> events;
    private ApiService api = Retrofit.getInstance();

    public LiveData<List<EventModel>> getEvents() {
        if (events == null) {
            events = new MutableLiveData<>();
            loadEvents();
        }
        return events;
    }

    private void loadEvents() {
        api.getEvents().enqueue(new Callback<List<EventModel>>() {
            @Override
            public void onResponse(Call<List<EventModel>> call, Response<List<EventModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    events.postValue(response.body());
                } else {
                    Log.e("EventViewModel", "Empty or error response: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<EventModel>> call, Throwable t) {
                Log.e("EventViewModel", "API failure: " + t.getMessage(), t);
            }
        });
    }

}
