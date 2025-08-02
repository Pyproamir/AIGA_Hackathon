package com.example.aiga_hackathon.client.profile.User;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aiga_hackathon.R;

import java.util.ArrayList;
import java.util.List;


public class BonusesFragment extends Fragment {


    private RecyclerView recyclerView;
    private List<Achievements> achievementList;
    private ImageView backButton;

    public BonusesFragment() {
        // Required empty public constructor
    }


    public static BonusesFragment newInstance(String param1, String param2) {
        BonusesFragment fragment = new BonusesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bonuses, container, false);

        recyclerView = view.findViewById(R.id.achievements_recycler);
        backButton = view.findViewById(R.id.iv_back_button);

        initData();

        AchievementsAdapter adapter = new AchievementsAdapter(getContext(), achievementList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        backButton.setOnClickListener(v -> requireActivity().onBackPressed());

        return view;
    }

    private void initData() {
        achievementList = new ArrayList<>();
        achievementList.add(new Achievements("Intermediate", "Obtain the purple belt", 25));
        achievementList.add(new Achievements("Advanced", "Win regional championship", 50));
        achievementList.add(new Achievements("Elite", "Train 100 days straight", 100));
    }
}