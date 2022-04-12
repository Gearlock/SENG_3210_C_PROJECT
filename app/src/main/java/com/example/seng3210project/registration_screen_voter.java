package com.example.seng3210project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registration_screen_voter extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    Button registrationButtonVoter;
    private EditText fname,lname,pass,DOB;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen_voter);

        database = FirebaseDatabase.getInstance("https://seng3210project-default-rtdb.firebaseio.com/");
        reference = database.getReference();
        fname = (EditText)findViewById(R.id.voterFirstName);
        lname = (EditText)findViewById(R.id.voterLastName);
        pass = (EditText)findViewById(R.id.voterPassword);
        DOB = (EditText)findViewById(R.id.voterAge);

    }
    public void addVoterInfoToDB(View view){
    switch (view.getId()){
        case R.id.registerVotertoDB:
            registervoter();
        break;
        case R.id.voterRegistrationBackToLogin:
        startActivity(new Intent(this,login_screen.class));
        break;
    }

    }

    private void registervoter() {
        database.getInstance().getReference("Voters");
    }


    public Button getRegistrationButtonVoter() {
        return registrationButtonVoter;
    }

    public void setRegistrationButtonVoter(Button registrationButtonVoter) {
        this.registrationButtonVoter = registrationButtonVoter;
    }


}