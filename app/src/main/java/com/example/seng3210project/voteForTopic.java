package com.example.seng3210project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class voteForTopic extends AppCompatActivity { // Function to to allow a voter to vote for or against a topic
    FirebaseDatabase database;
    DatabaseReference reference,innerReference;
    private TextView topicDisplay;
    private String topicFromDB,topicNameFromDB;
    int yesVote,noVote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vote_for_topic);
        reference = database.getInstance().getReference().child("Topic");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String topicNameFromDB = dataSnapshot.child("topicName").getValue().toString();
                    topicDisplay = (TextView) findViewById(R.id.votingTopic);
                    topicDisplay.setText("Topic details \n"+ topicNameFromDB);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database = FirebaseDatabase.getInstance("https://seng3210project-default-rtdb.firebaseio.com/");
    }

    public void IntentVoterMainPage(View view) {
        startActivity(new Intent(getApplicationContext(),voterMainPage.class));
    }

    public void voterVoteFor(View view) {
        reference = database.getInstance().getReference().child("Topic");
        innerReference = reference.child(topicNameFromDB);
        yesVote++;
        innerReference.child("Yes votes").setValue(yesVote);
        startActivity(new Intent(getApplicationContext(),voterMainPage.class));
        Toast.makeText(this,"Vote cast successfully", Toast.LENGTH_LONG);
    }

    public void voterVoteAgainst(View view) {
        reference = database.getInstance().getReference().child("Topic");
        innerReference = reference.child(topicNameFromDB);
        noVote++;
        innerReference.child("No votes").setValue(noVote);
        startActivity(new Intent(getApplicationContext(),voterMainPage.class));
        Toast.makeText(this,"Vote cast successfully", Toast.LENGTH_LONG);
    }
}