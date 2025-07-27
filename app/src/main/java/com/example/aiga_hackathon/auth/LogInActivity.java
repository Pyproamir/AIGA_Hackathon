package com.example.aiga_hackathon.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aiga_hackathon.R;

public class LogInActivity extends AppCompatActivity {

    EditText email, password;
    ImageView seePassword, passwordMark, emailMark;
    ImageButton signButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        email = findViewById(R.id.email_editText);
        password = findViewById(R.id.password_edit_text);
        seePassword = findViewById(R.id.see_password);
        signButton = findViewById(R.id.sign_in_button);
        backButton = findViewById(R.id.back_button);
        emailMark = findViewById(R.id.email_mark_signIn);
        passwordMark = findViewById(R.id.password_mark_signIn);

        signButton.setOnClickListener(v->{
            String emailStr = email.getText().toString().trim();
            String passwordStr = password.getText().toString().trim();
            signInProcess(email, password);

            if (emailStr.isEmpty()) {
                Toast.makeText(this, "Enter a valid email address.", Toast.LENGTH_LONG).show();
                return;
            }

            if (passwordStr.isEmpty()) {
                Toast.makeText(this, "Password cannot be empty.", Toast.LENGTH_LONG).show();
                return;
            }



            if (!checkAccount(email)) {
                Toast.makeText(this, "You don’t have an account. Please sign up.", Toast.LENGTH_LONG).show();
                return;
            }

            if (!checkPassword(email, password)) {
                Toast.makeText(this, "Your password is not valid.", Toast.LENGTH_LONG).show();
                return;
            }

            performLogin(emailStr, passwordStr);

        });

    }

    private void signInProcess(EditText email, EditText password){
        String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

        if(checkData(email, emailPattern, R.id.email_mark_signIn, emailMark, "Enter a valid email (e.g., example@mail.com)") ||
                checkData(password, passwordPattern, R.id.password_mark_signIn, passwordMark, "Min 8 chars, at least 1 letter and 1 number") ||
                checkAccount(email) || checkPassword(email, password)){
            return;
        }

        Intent intent = new Intent(LogInActivity.this, LogInActivity.class);
        startActivity(intent);
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

    private void performLogin(String emailStr, String passwordStr) {

    }

    private boolean checkPassword(EditText email, EditText password) {

        return false;
    }

    private boolean checkAccount(EditText email) {
        return false;
    }

}