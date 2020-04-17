package com.example.studentlistapp.ui.main;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Users>> liveData;
    private MutableLiveData<ArrayList<Users>> liveData1;


    public void init (){
         if(liveData != null){
             return;
         }

         liveData = Repo.getInstance().getNames();
    }

    public LiveData<ArrayList<Users>> getLiveData(){
        return liveData;
    }

}
