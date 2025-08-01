package com.example.aiga_hackathon.client;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aiga_hackathon.R;
import com.example.aiga_hackathon.client.drop_down_list.TrainingAdapter;
import com.example.aiga_hackathon.client.drop_down_list.TrainingItem;
import com.example.aiga_hackathon.client.drop_down_list.DropDownListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrainingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrainingsFragment extends Fragment {

    ArrayList<TrainingItem> trainingItems = new ArrayList<>();

    private DropDownListView dropDownListView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TrainingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrainingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrainingsFragment newInstance(String param1, String param2) {
        TrainingsFragment fragment = new TrainingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trainings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        trainingItems.add(new TrainingItem(
                "Jiu-Jitsu Training",
                "Nurlan Algaziz",
                "2.08.2025",
                "17:00",
                "Abylikhan 56"));

        trainingItems.add(new TrainingItem(
                "Jiu-Jitsu Training",
                "Nurlan Algaziz",
                "3.08.2025",
                "15:00",
                "Abylikhan 56"));

        dropDownListView = view.findViewById(R.id.AlmatyDropDownListTraining);

        TrainingAdapter adapterAlmaty = new TrainingAdapter(
                requireContext(),
                R.layout.custom_drop_down_training_item,
                trainingItems
        );

        dropDownListView.<TrainingItem>SetAdapterForList(adapterAlmaty);
    }

}