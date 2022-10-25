package com.example.viewpagerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogINActivity extends AppCompatActivity {
    Button logInBtn ,cancelBtn;
    TextView  attemptLeftText;
    EditText nameEdit, passwordEdit;
    String name, password ;
    Boolean nameIsValid = false;
    Boolean passwordIsValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_inactivity);
        logInBtn =findViewById(R.id.log_in_btn);
        cancelBtn = findViewById(R.id.cancel_btn);
        nameEdit = findViewById(R.id.name_edit);
        passwordEdit = findViewById(R.id.password_edit);
        attemptLeftText = findViewById(R.id.attempt_left_text);
        logInBtn.setOnClickListener((v)->{
            name = nameEdit.getText().toString();
            password = passwordEdit.getText().toString();
            nameIsValid = CheckName(name);
            passwordIsValid = CheckPassword(password);
            if(nameIsValid && passwordIsValid){
                //start the main activity
                Intent goToApp = new Intent(this, MainActivity.class);
                startActivity(goToApp);
//                nameEdit.getText().clear();
//                passwordEdit.getText().clear();

            }else if(passwordIsValid){
                //say the name is not valid
            }else{
                //say the password is not valid
            }
        });
        cancelBtn.setOnClickListener((v)->{
            nameEdit.getText().clear();
            passwordEdit.getText().clear();
        });


    }

    private Boolean CheckPassword(String password) {
        return true;
    }

    private Boolean CheckName(String name) {
        return true;
    }
}