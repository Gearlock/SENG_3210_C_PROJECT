package com.example.seng3210project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class voter_voting_results_page extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    private TextView voterTopicVote,voterTopicName;
    private String TopicNameVoter, TopicVoteYesVoter,TopicVoteNoVoter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voter_voting_results_page);
        voterTopicName = (TextView)findViewById(R.id.resultsTopicName);
        voterTopicVote = (TextView)findViewById(R.id.topicResult);
        reference = database.getInstance().getReference().child("Topic");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String TopicNameVoter = dataSnapshot.child("topicName").getValue().toString();
                    String TopicVoteYesVoter = dataSnapshot.child("Yes votes").getValue().toString();
                    String TopicVoteNoVoter = dataSnapshot.child("No votes").getValue().toString();
                    voterTopicName.setText("Topic Name \n"+TopicNameVoter);
                    voterTopicVote.setText("For: \n"+TopicVoteYesVoter+"\n Against: \n"+TopicVoteNoVoter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void IntentVoterMainPage(View view) {
        startActivity(new Intent(getApplicationContext(),voterMainPage.class));
    }
}