package com.example.seng3210project;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAO {
    FirebaseDatabase database;
    DatabaseReference reference;

    public FirebaseDatabase dataInstance(){
        database = FirebaseDatabase.getInstance("https://seng3210project-default-rtdb.firebaseio.com/");
        return database;
    }

    public DatabaseReference ref(String path){
        reference = database.getInstance().getReference(path);
        return reference;
    }

    public DatabaseReference DBchild(String pat){
        reference = database.getInstance().getReference().child(pat);
        return reference;
    }


}


