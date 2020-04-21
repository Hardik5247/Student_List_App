package com.example.studentlistapp.ui.Fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studentlistapp.R;
import com.example.studentlistapp.ui.Adapters.MyAdapter;
import com.example.studentlistapp.ui.Adapters.MyDialog;
import com.example.studentlistapp.ui.main.ItemClickListener;
import com.example.studentlistapp.ui.ViewModel.MainViewModel;
import com.example.studentlistapp.ui.Model.Users;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainFragment extends Fragment implements ItemClickListener {

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
        String[] array = new String[4];

        array[0] = users.get(position).getUserName();
        array[1] = users.get(position).getUserNumber();
        array[2] = users.get(position).getUserBhavan();
        array[3] = users.get(position).getUserBranch();

        Bundle bundle = new Bundle();
        bundle.putStringArray("array",array);

        Navigation.findNavController(view).navigate(R.id.detailsFragment,bundle);
    }
}
