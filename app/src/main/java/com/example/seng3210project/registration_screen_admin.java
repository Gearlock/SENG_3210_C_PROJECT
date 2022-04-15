package com.example.seng3210project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// Registration process for registering an administrator to the system
public class registration_screen_admin extends AppCompatActivity {
    // Set up firebase database
  DAO data = new DAO();

    Button registrationButtonVoter;

    // Variables for admin user info
    public EditText getFname() {
        return fname;
    }

    public void setFname(EditText fname) {
        this.fname = fname;
    }

    private EditText fname;

    public EditText getLname() {
        return lname;
    }

    public void setLname(EditText lname) {
        this.lname = lname;
    }

    private EditText lname;

    public EditText getPass() {
        return pass;
    }

    public void setPass(EditText pass) {
        this.pass = pass;
    }

    private EditText pass;

    public EditText getAGE() {
        return AGE;
    }

    public void setAGE(EditText AGE) {
        this.AGE = AGE;
    }

    private EditText AGE;

    public String getFiName() {
        return fiName;
    }

    public void setFiName(String fiName) {
        this.fiName = fiName;
    }

    private String fiName;

    public String getLaName() {
        return laName;
    }

    public void setLaName(String laName) {
        this.laName = laName;
    }

    private String laName;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    private String passWord;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen_admin);
    }

    public void addAdminInfoToDB(View view){ // Function to add the inputted admin info to the database
        fname = (EditText)findViewById(R.id.adminFirstName);
        lname = (EditText)findViewById(R.id.adminLastName);
        pass = (EditText)findViewById(R.id.adminPassword);
        AGE = (EditText) findViewById(R.id.adminAge);
        fiName = fname.getText().toString();
        laName = lname.getText().toString();
        passWord = pass.getText().toString();
        age = AGE.getText().toString();
       data.dataInstance(); // Get database instance
        Admin newAdmin = new Admin(fiName,laName,passWord,age); // Make a new admin with inputted info
        data.ref("Admin");
        data.ref("Admin").child(newAdmin.firstname).setValue(newAdmin); // Add the admin to the database

    }

    public void gotologinfromadmin(View view){
        startActivity(new Intent(this,login_screen.class)); // Go to the log-in screen
    }

}