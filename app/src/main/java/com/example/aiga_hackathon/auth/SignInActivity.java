package com.example.aiga_hackathon.auth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aiga_hackathon.R;
import com.example.aiga_hackathon.client.ClientActivity;

public class SignInActivity extends AppCompatActivity {

    EditText email, password;
    ImageView seePassword;
    ImageButton signButton, backButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
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
        textView = findViewById(R.id.textView);

        makeClickableText(textView);

        signButton.setOnClickListener(v->{
            signInProcess(email, password);
        });

        backButton.setOnClickListener(v->{
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        seePassword.setOnClickListener(v -> {
            if (password.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                seePassword.setImageResource(R.drawable.ic_hide_password);
            } else {
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                seePassword.setImageResource(R.drawable.eye_show_up_arrow);
            }
            password.setSelection(password.getText().length());
        });

    }

    private void makeClickableText(TextView textView) {
        SpannableString ss = new SpannableString("Already have an account. Sign Up");

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
                finish();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };

        ss.setSpan(clickableSpan, 25, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);
    }

    private void signInProcess(EditText email, EditText password){
        String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

        boolean isEmailValid = checkData(email, emailPattern,  "Enter a valid email (e.g., example@mail.com)");
        boolean isPasswordValid = checkData(password, passwordPattern, "Min 8 chars, at least 1 letter and 1 number");

        if(isEmailValid || isPasswordValid || !checkAccount(email) || !checkPassword(email, password)){
            return;
        }

        SharedPreferences prefs = getSharedPreferences("auth", MODE_PRIVATE);
        prefs.edit().putBoolean("logged_in", true).apply();
        startActivity(new Intent(this, ClientActivity.class));
        finish();
    }

    private boolean checkData(EditText data, String dataPattern, String messageError){
        String dataStr = data.getText().toString().trim();
        if (dataStr.isEmpty() || !dataStr.matches(dataPattern)) {
            data.setError(messageError);
            return true;
        }
        else{
            data.setError(null);
            return false;
        }
    }

    private boolean checkPassword(EditText email, EditText password) {
        return true;
    }

    private boolean checkAccount(EditText email) {
        return true;
    }

}