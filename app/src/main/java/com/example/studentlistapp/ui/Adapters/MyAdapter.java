package com.example.studentlistapp.ui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentlistapp.R;
import com.example.studentlistapp.ui.main.ItemClickListener;
import com.example.studentlistapp.ui.Model.Users;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private ArrayList<Users> users;
    private ItemClickListener clickListener;

    public MyAdapter(ArrayList<Users> users){
        this.users = users;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemView.setTag(users.get(position));
        String string = users.get(position).getUserName() + ", " + users.get(position).getUserNumber();
        holder.name.setText(string);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.onClick(view, getAdapterPosition());
            }
        }
    }
}

