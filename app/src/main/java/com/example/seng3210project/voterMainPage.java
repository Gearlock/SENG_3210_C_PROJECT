package com.example.seng3210project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class voterMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voter_main_page);
    }

    public void IntentVoterResults(View view) {
        startActivity(new Intent(getApplicationContext(),voter_voting_results_page.class));
    }

    public void IntentVotingForTopic(View view) {
        startActivity(new Intent(getApplicationContext(),voteForTopic.class));
    }


}