package com.example.aiga_hackathon.client.profile;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiga_hackathon.R;
import com.example.aiga_hackathon.client.ApiService;
import com.example.aiga_hackathon.client.Retrofit;
import com.example.aiga_hackathon.client.profile.User.UserModel;
import com.example.aiga_hackathon.client.profile.User.UserViewModel;


public class PersonalInfoFragment extends Fragment {

    private ConstraintLayout personalInfoConstraint, birthdayConstraint, addressConstraint, socialMediaConstraint, recoveryCodeConstraint;
    private TextView contactInfo, birthday, address, socialMedia, recoveryCode, name, sport_type;
    private ImageView user_image;
    private ImageButton backButton;

    public PersonalInfoFragment() {
        // Required empty public constructor
    }

    public static PersonalInfoFragment newInstance(String param1, String param2) {
        PersonalInfoFragment fragment = new PersonalInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_info, container, false);
        personalInfoConstraint = view.findViewById(R.id.personal_info_Constraint);
        birthdayConstraint = view.findViewById(R.id.birthday_Constraint);
        addressConstraint = view.findViewById(R.id.address_Constraint);
        socialMediaConstraint = view.findViewById(R.id.social_media_Constraint);
        recoveryCodeConstraint = view.findViewById(R.id.recovery_code_Constraint);

        contactInfo = view.findViewById(R.id.tx_contact_info);
        birthday = view.findViewById(R.id.tx_birthday);
        address = view.findViewById(R.id.tx_address);
        socialMedia = view.findViewById(R.id.tx_social_media);
        recoveryCode = view.findViewById(R.id.tx_recovery_code);
        sport_type = view.findViewById(R.id.tx_personal_info_name);
        name = view.findViewById(R.id.tx_personal_info_name);
        user_image = view.findViewById(R.id.iv_personal_info_image);
        backButton = view.findViewById(R.id.ib_back_button_person_info);

        backButton.setOnClickListener(v->{
            NavController navController = NavHostFragment.findNavController(PersonalInfoFragment.this);
            if (!navController.popBackStack()) {
                requireActivity().onBackPressed();
            }
        });

        UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.loadUser(name.getText().toString());
        userViewModel.user.observe(getViewLifecycleOwner(), user -> {
            if (user != null) {
                contactInfo.setText(user.getPhoneNumber());
                birthday.setText(user.getBirthday());
                address.setText(user.getEmail());
                sport_type.setText(user.getSport_type());
            }
        });
        return view;
    }
}