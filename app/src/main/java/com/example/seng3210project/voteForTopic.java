package com.example.seng3210project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class voteForTopic extends AppCompatActivity { // Function to to allow a voter to vote for or against a topic

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vote_for_topic);
    }

    public void IntentAdminMainPage(View view) {
        startActivity(new Intent(getApplicationContext(),manager_main_page.class));
    }
}