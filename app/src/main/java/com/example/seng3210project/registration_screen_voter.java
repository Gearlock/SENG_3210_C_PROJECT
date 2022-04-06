package com.example.seng3210project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registration_screen_voter extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    Button registrationButtonVoter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen_voter);
        registrationButtonVoter = findViewById(R.id.registerVotertoDB);

        registrationButtonVoter.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("Users");
            reference.setValue("Sam G");
        }
        });
    }

    public Button getRegistrationButtonVoter() {
        return registrationButtonVoter;
    }

    public void setRegistrationButtonVoter(Button registrationButtonVoter) {
        this.registrationButtonVoter = registrationButtonVoter;
    }


}