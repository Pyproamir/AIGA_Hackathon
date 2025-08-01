package com.example.aiga_hackathon.client;

import android.content.Intent;
import android.graphics.Rect;
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
import com.example.aiga_hackathon.client.events.EventModel;
import com.example.aiga_hackathon.client.events.EventViewModel;
import com.example.aiga_hackathon.client.profile.ProfileActivity;
import com.example.aiga_hackathon.client.trainer_list.TrainerListAdapter;
import com.example.aiga_hackathon.client.trainer_list.TrainerListModel;
import com.example.aiga_hackathon.client.trainer_list.TrainerListViewModel;

import java.util.ArrayList;
import java.util.List;


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

        List<TrainerListModel> trainerListModels = new ArrayList<>();
        trainerListModels.add(new TrainerListModel(R.drawable.trainer_list_1,
                "Marcos A.", "K&A groups", 4.9F));
        trainerListModels.add(new TrainerListModel(R.drawable.trainer_list_2,
                "Ruslan I.", "A group", 4.8F));
        trainerListAdapter.setTrainerList(trainerListModels);
        trainerListAdapter.notifyDataSetChanged();

        /*trainerListViewModel.getTrainers().observe(getViewLifecycleOwner(), trainerList->{
            trainerListAdapter.setTrainerList(trainerListModels);
            trainerListAdapter.notifyDataSetChanged();
        });*/

        //___
        eventsRecycler = view.findViewById(R.id.events_recyclerView);
        eventViewModel = new ViewModelProvider(this).get(EventViewModel.class);

        eventsRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        eventsRecycler.setHasFixedSize(true);
        VerticalSpaceItemDecoration verticalSpaceItemDecoration = new VerticalSpaceItemDecoration(16);
        eventsRecycler.addItemDecoration(verticalSpaceItemDecoration);

        eventAdapter = new EventAdapter(this, new ArrayList<>(), eventViewModel);
        eventsRecycler.setAdapter(eventAdapter);

        List<EventModel> eventModels = new ArrayList<>();
        eventModels.add(new EventModel("https://smoothcomp.com/pictures/t/6004061-t5lo/kubok-respubliki-kazaxstan-po-grepplingu-aiga-sredi-iunisei-iuniorov-molodezi-i-vzroslyx-2025.jpg",
                true, false, "Almaty Konayev Jiu-Jitsu Cup"));
        eventModels.add(new EventModel("https://smoothcomp.com/pictures/t/761454-3qjd/chempionat-respubliki-kazakhstan-po-grepplingu-aiga-sredi-vzroslykh-2020.jpg",
                false, true, "Almaty Konayev Jiu-Jitsu Cup"));

        eventAdapter.setEvents(eventModels);
        eventAdapter.notifyDataSetChanged();
        /*eventViewModel.getEvents().observe(getViewLifecycleOwner(), eventModels -> {
            eventAdapter.setEvents(eventModels);
            eventAdapter.notifyDataSetChanged();
        });*/

        profileIcon = view.findViewById(R.id.iv_profile);
        profileIcon.setOnClickListener(v->{
            startActivity(new Intent(requireContext(), ProfileActivity.class));
        });

        return view;
    }





}

