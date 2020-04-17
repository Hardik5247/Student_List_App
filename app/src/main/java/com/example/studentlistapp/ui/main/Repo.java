package com.example.studentlistapp.ui.main;


import android.app.DownloadManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Queue;

public class Repo {

    static Repo instance;
    private ArrayList<Users> users = new ArrayList<>();
    private MutableLiveData<ArrayList<Users>> name = new MutableLiveData<>();




    public static Repo getInstance() {

        if(instance == null){
            instance = new Repo();
        }

        return instance;
    }

    public MutableLiveData<ArrayList<Users>> getNames(){
        if(users.size() == 0) {
            loadNames();
        }

        name.setValue(users);

        return name;
    }

    private void loadNames() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        Query query = reference.child("Users");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot :dataSnapshot.getChildren()) {

                    users.add(snapshot.getValue(Users.class));
                }
                name.postValue(users);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
