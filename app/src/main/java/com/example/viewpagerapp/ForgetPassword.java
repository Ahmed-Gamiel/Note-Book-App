package com.example.viewpagerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    private EditText emailAddress;
    private TextView goToLogInPage;
    private Button recoverPassword;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        firebaseAuth= FirebaseAuth.getInstance();
        emailAddress = findViewById(R.id.email_address_edit);
        goToLogInPage = findViewById(R.id.gobacktologin);
        recoverPassword = findViewById(R.id.recover_btn);

        goToLogInPage.setOnClickListener((v)->{
            Intent logInPageIntent= new Intent(this,LogINActivity.class);
            finish();
            startActivity(logInPageIntent);
        });

        recoverPassword.setOnClickListener((v)->{
            String mail = emailAddress.getText().toString().trim();
            if(mail.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Enter your mail first",Toast.LENGTH_SHORT).show();
            }
            else
            {
                //send email
                firebaseAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Mail Sent , You can recover your password using mail",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Email is Wrong or Account Not Exist",Toast.LENGTH_SHORT).show();
                        }


                    }
                });
            }
        });


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