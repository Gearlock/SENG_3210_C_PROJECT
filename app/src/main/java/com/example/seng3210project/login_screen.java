package com.example.seng3210project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// Log in screen for voters and administrators
public class login_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
    }
    public void IntentRegistrationScreen(View view){
        startActivity(new Intent(getApplicationContext(),MainActivity.class)); // Goes to the main registration screen
    }
}