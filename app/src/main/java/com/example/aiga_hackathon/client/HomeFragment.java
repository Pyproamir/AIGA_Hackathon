package com.example.aiga_hackathon.client;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aiga_hackathon.R;
import com.example.aiga_hackathon.client.events.EventAdapter;
import com.example.aiga_hackathon.client.events.EventViewModel;
import com.example.aiga_hackathon.client.trainer_list.TrainerListAdapter;
import com.example.aiga_hackathon.client.trainer_list.TrainerListModel;
import com.example.aiga_hackathon.client.trainer_list.TrainerListViewModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private RecyclerView trainerListRecycler, eventsRecycler;
    private TrainerListModel trainerList;
    private TrainerListViewModel trainerListViewModel;
    private TrainerListAdapter trainerListAdapter;
    private EventAdapter eventAdapter;
    private EventViewModel eventViewModel;
    private ImageView profileIcon;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        trainerListRecycler = view.findViewById(R.id.trainer_list_recyclerView);
        trainerListViewModel = new ViewModelProvider(this).get(TrainerListViewModel.class);

        trainerListRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        trainerListRecycler.setHasFixedSize(true);

        trainerListAdapter = new TrainerListAdapter(this, new ArrayList<>(), trainerListViewModel);
        trainerListRecycler.setAdapter(trainerListAdapter);

        trainerListViewModel.getTrainers().observe(getViewLifecycleOwner(), trainerList->{
            trainerListAdapter.setTrainerList(trainerList);
            trainerListAdapter.notifyDataSetChanged();
        });

        //___
        eventsRecycler = view.findViewById(R.id.events_recyclerView);
        eventViewModel = new ViewModelProvider(this).get(EventViewModel.class);

        eventsRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        eventsRecycler.setHasFixedSize(true);

        eventAdapter = new EventAdapter(this, new ArrayList<>(), eventViewModel);
        eventsRecycler.setAdapter(eventAdapter);

        eventViewModel.getEvents().observe(getViewLifecycleOwner(), eventModels -> {
            eventAdapter.setEvents(eventModels);
            eventAdapter.notifyDataSetChanged();
        });

        profileIcon = view.findViewById(R.id.iv_profile);
        profileIcon.setOnClickListener(v->{
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_homeFragment_to_profileActivity);
        });

        return view;
    }





}