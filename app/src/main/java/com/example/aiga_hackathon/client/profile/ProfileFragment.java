package com.example.aiga_hackathon.client.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiga_hackathon.R;
import com.example.aiga_hackathon.auth.MainActivity;
import com.example.aiga_hackathon.client.HomeFragment;
import com.example.aiga_hackathon.client.profile.User.UserViewModel;


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
        ConstraintLayout banks = view.findViewById(R.id.banks_Constraint);
        ConstraintLayout dashboard = view.findViewById(R.id.dashboard_Constraint);
        ConstraintLayout bonuses = view.findViewById(R.id.bonuses_Constraint);

        TextView profileName = view.findViewById(R.id.tx_profile_name);
        TextView profileSport = view.findViewById(R.id.tx_profile_sport);
        ImageView profileImage = view.findViewById(R.id.iv_profile_image);
        ImageButton backButton = view.findViewById(R.id.ib_back_button_profile);

        backButton.setOnClickListener(v->{
            NavController navController = NavHostFragment.findNavController(ProfileFragment.this);
            if (!navController.popBackStack()) {
                requireActivity().onBackPressed();
            }
        });


        UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.loadUser(profileName.getText().toString());
        userViewModel.user.observe(getViewLifecycleOwner(), user -> {
            if (user != null) {
                profileName.setText(user.getName());
                profileSport.setText(user.getSport_type());
            }
        });

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

        bonuses.setOnClickListener(v ->
                navController.navigate(
                        R.id.action_profileActivity_to_bonuses_fragment));





        return view;
    }
}