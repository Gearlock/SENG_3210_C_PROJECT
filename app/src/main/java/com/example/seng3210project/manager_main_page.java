package com.example.seng3210project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class manager_main_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_main_page);
    }

    public void gotoadminregisterfromadminmain(View view) {
        startActivity(new Intent(getApplicationContext(),registration_screen_admin.class));
    }

    public void gotovotingresults(View view) {
        startActivity(new Intent(getApplicationContext(),admin_voting_results_page.class));
    }

    public void gotocreatevotingtopic(View view) {
        startActivity(new Intent(getApplicationContext(),add_topic.class));
    }

    public void gotologinfromadmin(View view) {
        startActivity(new Intent(getApplicationContext(),login_screen.class));
    }

}