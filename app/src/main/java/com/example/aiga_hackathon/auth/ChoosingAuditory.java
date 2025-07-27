package com.example.aiga_hackathon.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aiga_hackathon.R;

public class ChoosingAuditory extends AppCompatActivity {

    ImageButton trainerButton, clientButton, parentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choosing_auditory);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        trainerButton = findViewById(R.id.trainer_button);
        clientButton = findViewById(R.id.client_button);
        parentButton = findViewById(R.id.parent_button);

        clientButton.setOnClickListener(v->{
            Intent intent = new Intent(ChoosingAuditory.this, );
        });
    }


}