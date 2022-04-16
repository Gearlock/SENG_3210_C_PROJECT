package com.example.seng3210project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
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
                    TopicNameVoter = dataSnapshot.child("topicName").getValue().toString();
                    TopicVoteYesVoter = Integer.parseInt(dataSnapshot.child("yes").getValue().toString());
                    TopicVoteNoVoter = Integer.parseInt(dataSnapshot.child("no").getValue().toString());
                    voterTopicName.setText("Topic Name \n" + TopicNameVoter);
                    if (whichOneWon(TopicVoteYesVoter,TopicVoteNoVoter)) {
                        voterTopicVote.setText("For won the vote with: \n" + TopicVoteYesVoter+" votes");
                    }
                    else{
                        voterTopicVote.setText("Against won the vote with: \n" + TopicVoteNoVoter+" votes");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public static boolean whichOneWon(int yes, int no){
        if(yes>no) {
            return true;
        }
        else{
            return false;
        }
    }

    public void IntentVoterMainPage(View view) {
        startActivity(new Intent(getApplicationContext(),voterMainPage.class));
    }

    public TextView getVoterTopicVote() {
        return voterTopicVote;
    }

    public void setVoterTopicVote(TextView voterTopicVote) {
        this.voterTopicVote = voterTopicVote;
    }

    public TextView getVoterTopicName() {
        return voterTopicName;
    }

    public void setVoterTopicName(TextView voterTopicName) {
        this.voterTopicName = voterTopicName;
    }

    public String getTopicNameVoter() {
        return TopicNameVoter;
    }

    public void setTopicNameVoter(String topicNameVoter) {
        TopicNameVoter = topicNameVoter;
    }

    public int getTopicVoteYesVoter() {
        return TopicVoteYesVoter;
    }

    public void setTopicVoteYesVoter(int topicVoteYesVoter) {
        TopicVoteYesVoter = topicVoteYesVoter;
    }

    public int getTopicVoteNoVoter() {
        return TopicVoteNoVoter;
    }

    public void setTopicVoteNoVoter(int topicVoteNoVoter) {
        TopicVoteNoVoter = topicVoteNoVoter;
    }

    public DAO getData() {
        return data;
    }

    public void setData(DAO data) {
        this.data = data;
    }
}