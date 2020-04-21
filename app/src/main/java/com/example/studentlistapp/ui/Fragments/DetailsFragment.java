package com.example.studentlistapp.ui.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.studentlistapp.R;
import com.example.studentlistapp.ui.ViewModel.MainViewModel;

public class DetailsFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private MainViewModel mainViewModel;
    private TextView name1;
    private TextView enroll1;
    private TextView branch1;
    private TextView bhavan1;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(String param1, String param2) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        mainViewModel = ViewModelProviders.of(this.getActivity()).get(MainViewModel.class);

        name1 = v.findViewById(R.id.textViewName);
        enroll1 = v.findViewById(R.id.textViewEnroll);
        bhavan1 = v.findViewById(R.id.textViewBhavan);
        branch1 = v.findViewById(R.id.textViewBranch);

        String[] array1 = getArguments().getStringArray("array");

        name1.setText(array1[0]);
        enroll1.setText(array1[1]);
        bhavan1.setText(array1[2]);
        branch1.setText(array1[3]);

        return v;
    }
}
