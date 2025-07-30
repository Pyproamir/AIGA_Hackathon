package com.example.aiga_hackathon.auth;

import android.content.Intent;
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

public class SignUpActivity extends AppCompatActivity {

    EditText email, password, name, phone;
    ImageView seePassword;
    ImageButton signButton, backButton;
    TextView textViewLink;

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
        password = findViewById(R.id.password_signup_editText);
        name = findViewById(R.id.name_editText);
        phone = findViewById(R.id.phone_editText);
        seePassword = findViewById(R.id.see_password_signup);
        signButton = findViewById(R.id.sign_up_button);
        backButton = findViewById(R.id.back_button_signup);
        textViewLink = findViewById(R.id.textLinkSignUp);

        makeClickableText(textViewLink);

        signButton.setOnClickListener(v->{
            signUpProcess(name, email, password, phone);
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
        SpannableString ss = new SpannableString("Already have an account. Sign In");

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
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

    private void signUpProcess(EditText name, EditText email, EditText password, EditText phone){
        String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        String namePattern = "^[A-Z][a-z]+(?: [A-Z][a-z]+)*$";
        String phonePattern = "^\\+?[1-9]\\d{7,14}$";

        boolean isNameValid = checkData(name, namePattern,  "Enter a valid full name (e.g., John Smith)");
        boolean isPhoneValid = checkData(phone, phonePattern,  "Enter a valid phone number (+XXXXXXXXXXX)");
        boolean isEmailValid = checkData(email, emailPattern,  "Enter a valid email (e.g., example@mail.com)");
        boolean isPasswordValid = checkData(password, passwordPattern,"Min 8 chars, at least 1 letter and 1 number");


        if(isNameValid || isPasswordValid || isPhoneValid || isEmailValid){
            return;
        }
        startActivity(new Intent(this, ChoosingAuditory.class));
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
}