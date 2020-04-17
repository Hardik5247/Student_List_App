package com.example.studentlistapp.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.studentlistapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainFragment extends Fragment implements ItemClickListener{

    public static String name;
    public static String enroll;
    public static String bhavan;
    public static String branch;

    private ArrayList<Users> users;
    private MainViewModel mViewModel;
    public RecyclerView recyclerView;
    public MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton floatingActionButton;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, container, false);
        recyclerView = v.findViewById(R.id.recyclerView1);
        floatingActionButton = v.findViewById(R.id.floatingActionButton4);



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.init();
        mViewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<Users>>() {
            @Override
            public void onChanged(ArrayList<Users> users) {
                myAdapter.notifyDataSetChanged();
            }
        });
        users = mViewModel.getLiveData().getValue();
        myAdapter = new MyAdapter(mViewModel.getLiveData().getValue());
        myAdapter.setClickListener(this);
        recyclerView.setAdapter(myAdapter);
    }

    public void openDialog() {
        MyDialog myDialog = new MyDialog();
        myDialog.show(getParentFragmentManager(), "MyDialog");
    }


    @Override
    public void onClick(View view, int position) {
        name = users.get(position).getUserName();
        enroll = users.get(position).getUserNumber();
        bhavan = users.get(position).getUserBhavan();
        branch = users.get(position).getUserBranch();
        Navigation.findNavController(view).navigate(R.id.detailsFragment);
    }
}
