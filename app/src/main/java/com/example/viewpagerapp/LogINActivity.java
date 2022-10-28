package com.example.viewpagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LogINActivity extends AppCompatActivity {
    RelativeLayout logIn ,goToSignUpPage;
    TextView  goToForgotPasswordPage;
    EditText emailEdit, passwordEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_inactivity);
        emailEdit = findViewById(R.id.email_address_edit);
        passwordEdit = findViewById(R.id.email_address_edit);
        goToForgotPasswordPage = findViewById(R.id.gotoforgotpassword);
        logIn = findViewById(R.id.login);
        goToSignUpPage = findViewById(R.id.gotosignup);
        goToForgotPasswordPage.setOnClickListener((v)->{
            Intent forgetPasswordPageIntent= new Intent(this,ForgetPassword.class);
            finish();
            startActivity(forgetPasswordPageIntent);
        });
        goToSignUpPage.setOnClickListener((v)->{
            Intent signupPageIntent= new Intent(this,signupActivity.class);
            finish();
            startActivity(signupPageIntent);
        });
        logIn.setOnClickListener((v)-> {
            String mail = emailEdit.getText().toString().trim();
            String password = passwordEdit.getText().toString().trim();
            if (mail.isEmpty() || password.isEmpty()) {
                Toast.makeText(getApplicationContext(), "All Fields are Required", Toast.LENGTH_SHORT).show();
            } else if (password.length() < 7) {
                Toast.makeText(getApplicationContext(), "Password should be at least 7 digits", Toast.LENGTH_SHORT).show();
            } else {
                //send to firebase
            }

        });
    }
}
