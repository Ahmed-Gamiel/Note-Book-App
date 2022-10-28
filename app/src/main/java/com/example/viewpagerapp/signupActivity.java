package com.example.viewpagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {
    private EditText emailAddress , passwordInput;
    private RelativeLayout signUp;
    private TextView goToLogInPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
        emailAddress = findViewById(R.id.email_address_edit);
        passwordInput = findViewById(R.id.password_edit);
        signUp = findViewById(R.id.signup);
        goToLogInPage = findViewById(R.id.gotologin_text);
        goToLogInPage.setOnClickListener((v)->{
            Intent logInPageIntent= new Intent(this,LogINActivity.class);
            finish();
            startActivity(logInPageIntent);
        });
        signUp.setOnClickListener((v)->{
            String mail = emailAddress.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();
            if(mail.isEmpty() || password.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"All Fields are Required",Toast.LENGTH_SHORT).show();
            }
            else if(password.length()<7)
            {
                Toast.makeText(getApplicationContext(),"Password should be at least 7 digits",Toast.LENGTH_SHORT).show();
            }
            else
            {
                //send to firebase
            }

        });


    }
}