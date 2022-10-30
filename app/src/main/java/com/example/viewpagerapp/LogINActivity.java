package com.example.viewpagerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogINActivity extends AppCompatActivity {
    RelativeLayout logIn ,goToSignUpPage;
    TextView  goToForgotPasswordPage;
    EditText emailEdit, passwordEdit;
    private FirebaseAuth firebaseAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_inactivity);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();

        if(firebaseUser!=null)
        {
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
        progressBar = findViewById(R.id.progress_bar);
        emailEdit = findViewById(R.id.email_address_edit);
        passwordEdit = findViewById(R.id.password_edit);
        goToForgotPasswordPage = findViewById(R.id.gotoforgotpassword);
        logIn = findViewById(R.id.login);
        goToSignUpPage = findViewById(R.id.gotosignup);
        goToForgotPasswordPage.setOnClickListener((v)->{
            Intent forgetPasswordPageIntent= new Intent(this,ForgetPassword.class);
            startActivity(forgetPasswordPageIntent);
        });
        goToSignUpPage.setOnClickListener((v)->{
            Intent signupPageIntent= new Intent(this,signupActivity.class);
            startActivity(signupPageIntent);
        });
        logIn.setOnClickListener((v)-> {
            String mail = emailEdit.getText().toString().trim();
            String password = passwordEdit.getText().toString().trim();
            Log.i("LogINActivity", String.valueOf(password.length()));
            if (mail.isEmpty() || password.isEmpty()) {
                Toast.makeText(getApplicationContext(), "All Fields are Required", Toast.LENGTH_SHORT).show();
            } else if (password.length() < 7) {
                Toast.makeText(getApplicationContext(), "Password should be at least 7 digits", Toast.LENGTH_SHORT).show();
            } else {
                //send to firebase
                progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if(task.isSuccessful())
                        {
                            CheckMailVerfication(mail);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Account Doesn't Exist",Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                        }


                    }
                });
            }

        });
    }
    private void CheckMailVerfication(String mail)
    {
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();

        if(firebaseUser.isEmailVerified()==true)
        {
            Toast.makeText(getApplicationContext(),"Logged In",Toast.LENGTH_SHORT).show();
            finish();
            Intent goTOHomePage =  new Intent(this,MainActivity.class );
            goTOHomePage.putExtra("User",mail);

            startActivity(goTOHomePage);

        }
        else
        {
            progressBar.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(),"Verify your mail first",Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }
}
