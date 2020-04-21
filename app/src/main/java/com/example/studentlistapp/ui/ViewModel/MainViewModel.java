package com.example.studentlistapp.ui.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.studentlistapp.ui.main.Repo;
import com.example.studentlistapp.ui.Model.Users;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Users>> liveData;

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
