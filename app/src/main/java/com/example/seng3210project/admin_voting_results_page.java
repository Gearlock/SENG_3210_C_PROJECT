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
    private String TopicNameAdmin, TopicVoteYesAdmin,TopicVoteNoAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_voting_results_page);
        adminTopicName = (TextView)findViewById(R.id.adminResultsTopicName);
        adminTopicVote = (TextView)findViewById(R.id.adminTopicResult);
        reference = database.getInstance().getReference();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                 TopicNameAdmin = dataSnapshot.child("Topic").getValue().toString();
                 adminTopicName.setText("Topic Name \n"+TopicNameAdmin);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        adminTopicVote.setText("Yes votes: \n"+TopicVoteYesAdmin+"\n No votes \n"+TopicVoteNoAdmin);
    }

    public void IntentAdminMainPage(View view) {
        startActivity(new Intent(getApplicationContext(),manager_main_page.class));
    }
}