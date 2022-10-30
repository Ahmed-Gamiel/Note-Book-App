package com.example.viewpagerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

public class signupActivity extends AppCompatActivity {
    private EditText emailAddress, passwordInput;
    private RelativeLayout signUp;
    private TextView goToLogInPage;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
        firebaseAuth = FirebaseAuth.getInstance();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        emailAddress = findViewById(R.id.email_address_edit);
        passwordInput = findViewById(R.id.password_edit);
        signUp = findViewById(R.id.signup);
        goToLogInPage = findViewById(R.id.gotologin_text);

        goToLogInPage.setOnClickListener((v) -> {
            Intent logInPageIntent = new Intent(this, LogINActivity.class);
            finish();
            startActivity(logInPageIntent);
        });
        signUp.setOnClickListener((v) -> {
            String mail = emailAddress.getText().toString().trim();
            String password = passwordInput.getText().toString();
            if (mail.isEmpty() || password.isEmpty()) {
                Toast.makeText(getApplicationContext(), "All Fields are Required", Toast.LENGTH_SHORT).show();
            } else if (password.length() < 7) {

                Toast.makeText(getApplicationContext(), "Password should be at least 7 digits", Toast.LENGTH_SHORT).show();
            } else {
                //send to firebase
                firebaseAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(this ,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
//                            FirebaseAuthException e = (FirebaseAuthException )task.getException();
//                            Toast.makeText(getApplicationContext(), "Failed Registration: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                            sendEmailVerification();
                        } else {
                            Toast.makeText(getApplicationContext(), "Failed To Register", Toast.LENGTH_SHORT).show();
                        }
                    }

                });


            }

        });
    }
    private void sendEmailVerification()
    {
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        Log.d("signupActivity", "createUserWithEmail:success");

        if(firebaseUser!=null)
        {
            firebaseUser.sendEmailVerification().addOnCompleteListener(this, task -> {
                Toast.makeText(getApplicationContext(),"Verification Email is Sent,Verify and Log In Again",Toast.LENGTH_SHORT).show();
                firebaseAuth.signOut();

            });
        }

        else
        {
            Toast.makeText(getApplicationContext(),"Failed To Send Verification Email",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}