package com.example.studentlistapp.ui.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.studentlistapp.R;
import com.example.studentlistapp.ui.Model.Users;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyDialog extends AppCompatDialogFragment {
    private EditText editTextName;
    private EditText editTextEnroll;
    private EditText editTextBranch;
    private EditText editTextBhavan;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.layout_dialog,null);

        editTextName = view.findViewById(R.id.editTextName);
        editTextEnroll = view.findViewById(R.id.editTextEnroll);
        editTextBhavan = view.findViewById(R.id.editTextBhavan);
        editTextBranch = view.findViewById(R.id.editTextBranch);

        builder.setView(view)
                .setTitle("Create User")
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String stringName = editTextName.getText().toString();
                        String stringEnroll = editTextEnroll.getText().toString();
                        String stringBhavan = editTextBhavan.getText().toString();
                        String stringBranch = editTextBranch.getText().toString();

                        Users user = new Users(stringName, stringEnroll,stringBhavan,stringBranch);

                        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Users");
                        String userId = mDatabase.push().getKey();

                        mDatabase.child(userId).setValue(user);
                    }
                });
        return builder.create();
    }
}
