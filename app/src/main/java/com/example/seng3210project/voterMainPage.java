package com.example.seng3210project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class voterMainPage extends AppCompatActivity { // The main page for the voter, where they can choose from several options

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voter_main_page);
    }

    public void IntentVoterResults(View view) {
        startActivity(new Intent(getApplicationContext(),voter_voting_results_page.class)); // Go to the Results page
    }

    public void IntentVotingForTopic(View view) {
        startActivity(new Intent(getApplicationContext(),voteForTopic.class)); // Go to Topic Voting page
    }


    public void IntentLoginScreen(View view) {
        startActivity(new Intent(getApplicationContext(),login_screen.class));
    }

    public void IntentVoterRegistration(View view) {
        startActivity(new Intent(getApplicationContext(),registration_screen_voter.class));
    }

}