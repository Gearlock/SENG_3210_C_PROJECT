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
import com.google.firebase.ktx.Firebase;

public class voteForTopic extends AppCompatActivity { // Function to to allow a voter to vote for or against a topic
    DatabaseReference innerReference;
    private TextView topicDisplay;
    private String topicFromDB,topicNameFromDB;
    int yesVote = 1,noVote = 1,yesFromDB,noFromDB;
    DAO data = new DAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vote_for_topic);
        data.DBchild("Topic");
        data.DBchild("Topic").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    topicNameFromDB = dataSnapshot.child("topicName").getValue().toString();
                    topicDisplay = (TextView) findViewById(R.id.votingTopic);
                    topicDisplay.setText("Topic details \n"+ topicNameFromDB);
                    yesFromDB = Integer.parseInt(dataSnapshot.child("yes").getValue().toString());
                    noFromDB = Integer.parseInt(dataSnapshot.child("no").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        data.dataInstance();

    }

    public void IntentVoterMainPage(View view) {
        startActivity(new Intent(getApplicationContext(),voterMainPage.class));
    }

    public void voterVoteFor(View view) {
        data.DBchild("Topic");
        innerReference = data.DBchild("Topic").child(topicNameFromDB);
            yesVote = yesVote + yesFromDB;
            innerReference.child("yes").setValue(yesVote);
            startActivity(new Intent(getApplicationContext(), voterMainPage.class));
            Toast.makeText(this, "Vote cast successfully", Toast.LENGTH_LONG);

    }
    public void voterVoteAgainst(View view) {
        data.DBchild("Topic");
        innerReference = data.DBchild("Topic").child(topicNameFromDB);
            noVote = noVote + noFromDB;
            innerReference.child("no").setValue(noVote);
            startActivity(new Intent(getApplicationContext(), voterMainPage.class));
            Toast.makeText(this, "Vote cast successfully", Toast.LENGTH_LONG);

    }

    public DatabaseReference getInnerReference() {
        return innerReference;
    }

    public void setInnerReference(DatabaseReference innerReference) {
        this.innerReference = innerReference;
    }

    public TextView getTopicDisplay() {
        return topicDisplay;
    }

    public void setTopicDisplay(TextView topicDisplay) {
        this.topicDisplay = topicDisplay;
    }

    public String getTopicFromDB() {
        return topicFromDB;
    }

    public void setTopicFromDB(String topicFromDB) {
        this.topicFromDB = topicFromDB;
    }

    public String getTopicNameFromDB() {
        return topicNameFromDB;
    }

    public void setTopicNameFromDB(String topicNameFromDB) {
        this.topicNameFromDB = topicNameFromDB;
    }

    public int getYesVote() {
        return yesVote;
    }

    public void setYesVote(int yesVote) {
        this.yesVote = yesVote;
    }

    public int getNoVote() {
        return noVote;
    }

    public void setNoVote(int noVote) {
        this.noVote = noVote;
    }

    public int getYesFromDB() {
        return yesFromDB;
    }

    public void setYesFromDB(int yesFromDB) {
        this.yesFromDB = yesFromDB;
    }

    public int getNoFromDB() {
        return noFromDB;
    }

    public void setNoFromDB(int noFromDB) {
        this.noFromDB = noFromDB;
    }

    public DAO getData() {
        return data;
    }

    public void setData(DAO data) {
        this.data = data;
    }
}