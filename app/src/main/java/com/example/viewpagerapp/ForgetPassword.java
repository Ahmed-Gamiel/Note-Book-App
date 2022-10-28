package com.example.viewpagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetPassword extends AppCompatActivity {
    private EditText emailAddress;
    private TextView goToLogInPage;
    private Button recoverPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        getSupportActionBar().hide();
        emailAddress = findViewById(R.id.email_address_edit);
        goToLogInPage = findViewById(R.id.gobacktologin);
        recoverPassword = findViewById(R.id.recover_btn);

        goToLogInPage.setOnClickListener((v)->{
            Intent logInPageIntent= new Intent(this,LogINActivity.class);
            finish();
            startActivity(logInPageIntent);
        });

        recoverPassword.setOnClickListener((v)->{
            String e_mailAddress = emailAddress.getText().toString().trim();
            if(e_mailAddress.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Enter your mail first",Toast.LENGTH_SHORT).show();
            }
            else
            {
                //send email
            }
        });


    }
}