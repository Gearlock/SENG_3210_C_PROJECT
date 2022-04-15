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

import org.w3c.dom.Text;

import java.util.Objects;

// Log in screen for voters and administrators
public class login_screen extends AppCompatActivity {

    private EditText firstName,password;
    private String enteredfirstName,enteredpassword,databaseFirstname,databasePassword;
    DAO data = new DAO();

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
        data.DBchild("Voters");

        data.DBchild("Voters").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    databaseFirstname = dataSnapshot.child("firstname").getValue().toString();
                    databasePassword = dataSnapshot.child("password").getValue().toString();
                    if(databaseFirstname.equals(enteredfirstName) && databasePassword.equals(enteredpassword)) {
                        startActivity(new Intent(getApplicationContext(),voterMainPage.class));
                        break;
                    }
                    else {
                        Toast.makeText(login_screen.this, "First name or Password is incorrect please try again", Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(login_screen.this,"ERROR GETTING DATA ", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void loginAsAdmin(View view) {
        firstName = (EditText) findViewById(R.id.registerFirstName);
        password = (EditText) findViewById(R.id.registerPassword);
        enteredpassword = password.getText().toString();
        enteredfirstName = firstName.getText().toString();
        data.DBchild("Admin");

        data.DBchild("Admin").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    databaseFirstname = dataSnapshot.child("firstname").getValue().toString();
                    databasePassword = dataSnapshot.child("password").getValue().toString();
                    if(databaseFirstname.equals(enteredfirstName) && databasePassword.equals(enteredpassword)) {
                        startActivity(new Intent(getApplicationContext(), manager_main_page.class));
                        break;
                    } else {
                        Toast.makeText(login_screen.this, "First name or Password is incorrect please try again", Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(login_screen.this, "ERROR GETTING DATA ", Toast.LENGTH_LONG).show();
            }
        });
    }

    public EditText getFirstName() {
        return firstName;
    }

    public void setFirstName(EditText firstName) {
        this.firstName = firstName;
    }

    public EditText getPassword() {
        return password;
    }

    public void setPassword(EditText password) {
        this.password = password;
    }

    public String getEnteredfirstName() {
        return enteredfirstName;
    }

    public void setEnteredfirstName(String enteredfirstName) {
        this.enteredfirstName = enteredfirstName;
    }

    public String getEnteredpassword() {
        return enteredpassword;
    }

    public void setEnteredpassword(String enteredpassword) {
        this.enteredpassword = enteredpassword;
    }

    public String getDatabaseFirstname() {
        return databaseFirstname;
    }

    public void setDatabaseFirstname(String databaseFirstname) {
        this.databaseFirstname = databaseFirstname;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public DAO getData() {
        return data;
    }

    public void setData(DAO data) {
        this.data = data;
    }
}