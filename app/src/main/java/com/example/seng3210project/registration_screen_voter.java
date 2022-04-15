package com.example.seng3210project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// Registration process for registering a voter to the system
public class registration_screen_voter extends AppCompatActivity {
    // Set up firebase database

    Button registrationButtonVoter;
    DAO data = new DAO();
    // Variables for voter user info
    private EditText fname,lname,pass,AGE;
    private String fiName,laName,passWord,age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen_voter);
    }

    public void addVoterInfoToDB(View view){ // Function to add the inputted voter info to the database
        fname = (EditText)findViewById(R.id.voterFirstName);
        lname = (EditText)findViewById(R.id.voterLastName);
        pass = (EditText)findViewById(R.id.voterPassword);
        AGE = (EditText) findViewById(R.id.voterAge);
        fiName = fname.getText().toString();
        laName = lname.getText().toString();
        passWord = pass.getText().toString();
        age = AGE.getText().toString();
       data.dataInstance(); // Get database instance
        Voter newVoter = new Voter(fiName,laName,passWord,age); // Make a new voter with inputted info
            data.ref("Voters");
            data.ref("Voters").child(newVoter.firstname).setValue(newVoter); // Add the voter to the database
    }

    public void gotologinfromvoter(View view){
        startActivity(new Intent(this,login_screen.class)); // Go to the log-in screen
    }

    public Button getRegistrationButtonVoter() {
        return registrationButtonVoter;
    }

    public void setRegistrationButtonVoter(Button registrationButtonVoter) {
        this.registrationButtonVoter = registrationButtonVoter;
    }

    public String getFiName() {
        return fiName;
    }

    public void setFiName(String fiName) {
        this.fiName = fiName;
    }

    public String getLaName() {
        return laName;
    }

    public void setLaName(String laName) {
        this.laName = laName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public EditText getFname() {
        return fname;
    }

    public void setFname(EditText fname) {
        this.fname = fname;
    }

    public EditText getLname() {
        return lname;
    }

    public void setLname(EditText lname) {
        this.lname = lname;
    }

    public EditText getPass() {
        return pass;
    }

    public void setPass(EditText pass) {
        this.pass = pass;
    }

    public EditText getAGE() {
        return AGE;
    }

    public void setAGE(EditText AGE) {
        this.AGE = AGE;
    }

    public DAO getData() {
        return data;
    }

    public void setData(DAO data) {
        this.data = data;
    }
}