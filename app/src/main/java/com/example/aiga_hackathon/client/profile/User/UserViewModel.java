package com.example.aiga_hackathon.client.profile.User;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {
    private final UserRepository repository = new UserRepository();
    public LiveData<UserModel> user;

    public void loadUser(String name) {
        user = repository.getUser(name);
    }
}