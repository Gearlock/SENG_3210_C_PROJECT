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

    private TextView voterTopicVote,voterTopicName;
    private String TopicNameVoter;
    int TopicVoteYesVoter,TopicVoteNoVoter;

    DAO data = new DAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voter_voting_results_page);
        voterTopicName = (TextView)findViewById(R.id.resultsTopicName);
        voterTopicVote = (TextView)findViewById(R.id.topicResult);
        data.DBchild("Topic");
        data.DBchild("Topic").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String TopicNameVoter = dataSnapshot.child("topicName").getValue().toString();
                    TopicVoteYesVoter = Integer.parseInt(dataSnapshot.child("Yes votes").getValue().toString());
                    TopicVoteNoVoter = Integer.parseInt(dataSnapshot.child("No votes").getValue().toString());
                    voterTopicName.setText("Topic Name \n" + TopicNameVoter);
                    if (TopicVoteYesVoter > TopicVoteNoVoter) {
                        voterTopicVote.setText("For won the vote with: \n" + TopicVoteYesVoter+" votes");
                    }
                    else{
                        voterTopicVote.setText("Against won the vote with: \n" + TopicVoteYesVoter+" votes");
                    }
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