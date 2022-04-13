package com.example.seng3210project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class admin_voting_results_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_voting_results_page);
    }

    public void IntentAdminMainPage(View view) {
        startActivity(new Intent(getApplicationContext(),manager_main_page.class));
    }
}