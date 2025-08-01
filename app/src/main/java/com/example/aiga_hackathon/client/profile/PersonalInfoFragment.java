package com.example.aiga_hackathon.client.profile;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aiga_hackathon.R;


public class PersonalInfoFragment extends Fragment {

    private ConstraintLayout personalInfoConstraint, birthdayConstraint, addressConstraint, socialMediaConstraint, recoveryCodeConstraint;
    private TextView contactInfo, birthday, address, socialMedia, recoveryCode;
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

        personalInfoConstraint = container.findViewById(R.id.personal_info_Constraint);
        birthdayConstraint = container.findViewById(R.id.birthday_Constraint);
        addressConstraint = container.findViewById(R.id.address_Constraint);
        socialMediaConstraint = container.findViewById(R.id.social_media_Constraint);
        recoveryCodeConstraint = container.findViewById(R.id.recovery_code_Constraint);

        contactInfo = container.findViewById(R.id.tx_contact_info);
        birthday = container.findViewById(R.id.tx_birthday);
        address = container.findViewById(R.id.tx_address);
        socialMedia = container.findViewById(R.id.tx_social_media);
        recoveryCode = container.findViewById(R.id.tx_recovery_code);



        return inflater.inflate(R.layout.fragment_personal_info, container, false);
    }
}