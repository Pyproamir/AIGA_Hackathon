package com.example.aiga_hackathon.client;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ak.KalendarView;
import com.example.aiga_hackathon.R;
import com.example.aiga_hackathon.client.drop_down_list.DropDownListView;
import com.example.aiga_hackathon.client.drop_down_list.TrainingAdapter;
import com.example.aiga_hackathon.client.drop_down_list.TrainingItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleFragment extends Fragment {

    DropDownListView trainingsList;
    DropDownListView coachesList;
    DropDownListView locationsList;

    ListView availableTrainingsList;

    KalendarView calendar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScheduleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScheduleFragment newInstance(String param1, String param2) {
        ScheduleFragment fragment = new ScheduleFragment();
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
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Date initialDate = new Date(125, 7, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        calendar = view.findViewById(R.id.calendar);
        calendar.setInitialSelectedDate(initialDate);

        trainingsList = view.findViewById(R.id.TrainingsDropDownListSchedule);
        coachesList = view.findViewById(R.id.CoachesDropDownListSchedule);
        locationsList = view.findViewById(R.id.LocationsDropDownListSchedule);

        availableTrainingsList = view.findViewById(R.id.AvailableTrainingListView);

        List<TrainingItem> trainingItems = new ArrayList<>(Arrays.asList(
                new TrainingItem(
                        "Swimming",
                        "Serik Amir",
                        "26.01.2025",
                        "10:00",
                        "Abylaikhan 56"
                )
        ));

        TrainingAdapter trainingAdapter = new TrainingAdapter(
                getContext(),
                R.layout.custom_drop_down_training_item,
                trainingItems
        );

        trainingsList.SetAdapterForList(trainingAdapter);



        List<TrainingItem> availableTrainingItems = new ArrayList<>(Arrays.asList(
                new TrainingItem(
                        "Swimming",
                        "Serik Amir",
                        sdf.format(initialDate),
                        "10:00",
                        "Abylaikhan 56"
                )
        ));

        TrainingAdapter availableTrainingAdapter = new TrainingAdapter(
                getContext(),
                R.layout.custom_drop_down_training_item,
                availableTrainingItems
        );

        availableTrainingsList.setAdapter(availableTrainingAdapter);


        calendar.setDateSelector(selectedDate -> {
                availableTrainingAdapter.clear();
                availableTrainingAdapter.add(
                        new TrainingItem(
                        "Swimming",
                        "Serik Amir",
                        sdf.format(selectedDate),
                        "10:00",
                        "Abylaikhan 56")
                );
                availableTrainingAdapter.notifyDataSetChanged();
            }
        );
    }
}