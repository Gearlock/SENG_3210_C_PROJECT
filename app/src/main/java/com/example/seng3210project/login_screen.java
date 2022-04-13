package com.example.seng3210project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

// Log in screen for voters and administrators
public class login_screen extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    private EditText firstName,password;
    private String enteredfirstName,enteredpassword,databaseFirstname,databasePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
    }
    public void IntentRegistrationScreen(View view){
        startActivity(new Intent(getApplicationContext(),MainActivity.class)); // Goes to the main registration screen
    }
    public void loginAsVoter(View view){
        firstName = (EditText)findViewById(R.id.registerFirstName);
        password = (EditText)findViewById(R.id.registerPassword);
        enteredpassword = password.getText().toString();
        enteredfirstName = firstName.getText().toString();
        reference = database.getInstance().getReference("Voters");

        reference.child("Voters").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                startActivity(new Intent(getApplicationContext(),voterMainPage.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(login_screen.this,"YOU MESSED IT UP AGAIN!", Toast.LENGTH_LONG).show();
            }
        });
    }

}