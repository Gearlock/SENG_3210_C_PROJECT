package com.example.seng3210project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registration_screen_voter extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    Button registrationButtonVoter;
    private EditText fname,lname,pass,DOB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen_voter);

        database = FirebaseDatabase.getInstance("https://seng3210project-default-rtdb.firebaseio.com/");
        reference = database.getReference();


    }
    public void addVoterInfo(View view){

        fname = (EditText)findViewById(R.id.voterFirstName);
        lname = (EditText)findViewById(R.id.voterLastName);
        pass = (EditText)findViewById(R.id.voterPassword);
        DOB = (EditText)findViewById(R.id.voterDOB);
        reference = database.getReference("Voter First Name");
        reference.setValue(fname.getText().toString());
        reference = database.getReference("Voter Last Name");
        reference.setValue(lname.getText().toString());
        reference = database.getReference("Voter Password");
        reference.setValue(pass.getText().toString());
        reference = database.getReference("Voter Date Of Birth");
        reference.setValue(DOB.getText().toString());
    }
    public Button getRegistrationButtonVoter() {
        return registrationButtonVoter;
    }

    public void setRegistrationButtonVoter(Button registrationButtonVoter) {
        this.registrationButtonVoter = registrationButtonVoter;
    }


}