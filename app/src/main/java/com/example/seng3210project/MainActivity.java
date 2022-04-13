package com.example.seng3210project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
// Main activity class, launches upon start of the app
// Shows the 'register as' screen
public class MainActivity extends AppCompatActivity {

    // Setting up firebase references
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void IntentVoterRegistration(View view){
        startActivity(new Intent(getApplicationContext(),registration_screen_voter.class)); // Go to the registration screen for the voter
    }
    public void IntentAdminRegistration(View view){
        startActivity(new Intent(getApplicationContext(),registration_screen_admin.class)); // Go to the registration screen for the admin
    }
    public void IntentLoginScreen(View view){
        startActivity(new Intent(getApplicationContext(),login_screen.class)); // Go to the log-in screen
    }

}
