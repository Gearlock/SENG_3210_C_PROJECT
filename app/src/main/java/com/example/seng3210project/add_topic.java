package com.example.seng3210project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_topic extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    private EditText tName,tStart,tEnd;
    private String toName,toSart,toEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_topic);
    }

    public void IntentAdminMainPage(View view) {
        startActivity(new Intent(getApplicationContext(),manager_main_page.class));
    }


    public void addTopictoDB(View view) {
        tName = (EditText)findViewById(R.id.topicName);
        tStart = (EditText)findViewById(R.id.topicStartDate);
        tEnd = (EditText)findViewById(R.id.topicEndDate);
        toName = tName.getText().toString();
        toSart = tStart.getText().toString();
        toEnd = tEnd.getText().toString();
        database = FirebaseDatabase.getInstance("https://seng3210project-default-rtdb.firebaseio.com/");
        Topic newTopic = new Topic(toName,toSart,toEnd);
        reference = database.getReference("Topic");
        reference.child(newTopic.topicName).setValue(newTopic);
    }
}