package com.example.aiga_hackathon.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aiga_hackathon.R;

public class SignUpActivity extends AppCompatActivity {

    EditText email, password, name, phone;
    ImageView seePassword, emailMark, phoneMark, nameMark, passwordMark;
    ImageButton signButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        email = findViewById(R.id.email_editText_signup);
        password = findViewById(R.id.password_singup_editText);
        name = findViewById(R.id.name_editText);
        phone = findViewById(R.id.phone_editText);
        seePassword = findViewById(R.id.see_password_signup);
        signButton = findViewById(R.id.sign_up_button);
        backButton = findViewById(R.id.back_button_signup);
        nameMark = findViewById(R.id.name_mark);
        phoneMark = findViewById(R.id.phone_mark);
        emailMark = findViewById(R.id.email_mark);
        passwordMark = findViewById(R.id.password_mark);

        signButton.setOnClickListener(v->{
            signUpProcess(name, email, password, phone);
        });



    }

    private void signUpProcess(EditText name, EditText email, EditText password, EditText phone){
        String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        String namePattern = "^[A-Z][a-z]+(?: [A-Z][a-z]+)*$";
        String phonePattern = "^\\+?[1-9]\\d{7,14}$";

        if(checkData(name, namePattern, R.id.name_mark, nameMark, "Enter a valid full name (e.g., John Smith)") ||
            checkData(phone, phonePattern, R.id.phone_mark, phoneMark, "EEnter a valid phone number (+XXXXXXXXXXX)") ||
            checkData(email, emailPattern, R.id.email_mark, emailMark, "Enter a valid email (e.g., example@mail.com)") ||
            checkData(password, passwordPattern, R.id.password_mark, passwordMark, "Min 8 chars, at least 1 letter and 1 number")){
            return;
        }

        startActivity(new Intent(this, ChoosingAuditory.class));
        finish();
    }

    private boolean checkData(EditText data, String dataPattern, int res, ImageView dataMark, String messageError){
        String dataStr = data.getText().toString().trim();
        if (dataStr.isEmpty() || !dataStr.matches(dataPattern)) {
            // Toast.makeText(this, messageError, Toast.LENGTH_LONG).show();
            dataMark.setImageResource(res);
            data.setError(messageError);
            return true;
        }
        else{
            dataMark.setImageResource(0);
            data.setError(null);
            return false;
        }
    }
}