package com.example.aiga_hackathon.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aiga_hackathon.R;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        FrameLayout mainLayout = findViewById(R.id.main);
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
                finish();
            }
        });

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//        btnSignIn = findViewById(R.id.btn_sign_in);
//        btnSignUp = findViewById(R.id.btn_sign_up);
//
//        btnSignIn.setOnClickListener(v->{
//            startActivity(new Intent(this, SignInActivity.class));
//            finish();
//        });
//
//        btnSignUp.setOnClickListener(v->{
//            startActivity(new Intent(this, SignUpActivity.class));
//            finish();
//        });
    }
}