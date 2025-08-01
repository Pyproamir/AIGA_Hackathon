package com.example.aiga_hackathon.client.profile;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aiga_hackathon.R;



public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ConstraintLayout settings = view.findViewById(R.id.settings_Constraint);
        ConstraintLayout personalInfo = view.findViewById(R.id.personal_info_Constraint);
        ConstraintLayout notification = view.findViewById(R.id.notification_Constraint);
        ConstraintLayout address = view.findViewById(R.id.address_Constraint);
        ConstraintLayout banks = view.findViewById(R.id.banks_Constraint);
        ConstraintLayout dashboard = view.findViewById(R.id.dashboard_Constraint);

        NavController navController = NavHostFragment.findNavController(this);


        personalInfo.setOnClickListener(v ->
                navController.navigate(
                        R.id.action_profileActivity_to_personal_info_fragment));

        settings.setOnClickListener(v ->
                navController.navigate(
                        R.id.action_profileActivity_to_settings_fragment));

        banks.setOnClickListener(v ->
                navController.navigate(
                        R.id.action_profileActivity_to_banks_fragment));

        dashboard.setOnClickListener(v ->
                navController.navigate(
                        R.id.action_profileActivity_to_dashboard_fragment));

        address.setOnClickListener(v ->
                navController.navigate(
                        R.id.action_profileActivity_to_address_fragment));

        notification.setOnClickListener(v ->
                navController.navigate(
                        R.id.action_profileActivity_to_notifications_fragment));

        return view;
    }
}