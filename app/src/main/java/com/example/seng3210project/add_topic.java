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
    DAO data = new DAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_topic);
    }

    public void IntentAdminMainPage(View view) {
        startActivity(new Intent(getApplicationContext(),manager_main_page.class));
    }


    public void addTopicTODB(View view) {
        tName = (EditText)findViewById(R.id.topicName);
        tStart = (EditText)findViewById(R.id.topicStartDate);
        tEnd = (EditText)findViewById(R.id.topicEndDate);
        toName = tName.getText().toString();
        toSart = tStart.getText().toString();
        toEnd = tEnd.getText().toString();
        data.dataInstance();
        Topic newTopic = new Topic(toName,toSart,toEnd,0,0);
        data.ref("Topic");
        data.ref("Topic").child(newTopic.topicName).setValue(newTopic);
    }

    public FirebaseDatabase getDatabase() {
        return database;
    }

    public void setDatabase(FirebaseDatabase database) {
        this.database = database;
    }

    public DatabaseReference getReference() {
        return reference;
    }

    public void setReference(DatabaseReference reference) {
        this.reference = reference;
    }

    public EditText gettName() {
        return tName;
    }

    public void settName(EditText tName) {
        this.tName = tName;
    }

    public EditText gettStart() {
        return tStart;
    }

    public void settStart(EditText tStart) {
        this.tStart = tStart;
    }

    public EditText gettEnd() {
        return tEnd;
    }

    public void settEnd(EditText tEnd) {
        this.tEnd = tEnd;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToSart() {
        return toSart;
    }

    public void setToSart(String toSart) {
        this.toSart = toSart;
    }

    public String getToEnd() {
        return toEnd;
    }

    public void setToEnd(String toEnd) {
        this.toEnd = toEnd;
    }
}