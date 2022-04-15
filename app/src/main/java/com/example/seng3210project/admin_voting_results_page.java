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

public class admin_voting_results_page extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    private TextView adminTopicVote,adminTopicName;
    private String TopicNameAdmin;
    int TopicVoteYesAdmin,TopicVoteNoAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_voting_results_page);
        adminTopicName = (TextView)findViewById(R.id.adminResultsTopicName);
        adminTopicVote = (TextView)findViewById(R.id.adminTopicResult);
        reference = database.getInstance().getReference().child("Topic");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                 String TopicNameAdmin = dataSnapshot.child("topicName").getValue().toString();
                 TopicVoteYesAdmin = Integer.parseInt(dataSnapshot.child("yes").getValue().toString()) - 1;
                 TopicVoteNoAdmin = Integer.parseInt(dataSnapshot.child("no").getValue().toString()) - 1;

                 adminTopicName.setText("Topic Name \n"+TopicNameAdmin);
                 adminTopicVote.setText("For: \n"+(TopicVoteYesAdmin)+"\n Against: \n"+(TopicVoteNoAdmin));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void IntentAdminMainPage(View view) {
        startActivity(new Intent(getApplicationContext(),manager_main_page.class));
    }
}