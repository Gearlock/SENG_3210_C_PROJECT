package com.example.seng3210project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void IntentVoterRegistration(View view){
        startActivity(new Intent(getApplicationContext(),registration_screen_voter.class));
    }
    public void IntentAdminRegistration(View view){
        startActivity(new Intent(getApplicationContext(),registration_screen_admin.class));
    }
    public void IntentLoginScreen(View view){
        startActivity(new Intent(getApplicationContext(),login_screen.class));
    }

}
