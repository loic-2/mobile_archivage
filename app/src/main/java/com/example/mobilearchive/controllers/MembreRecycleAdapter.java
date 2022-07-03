package com.example.mobilearchive.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilearchive.R;
import com.example.mobilearchive.models.Membre;

import java.util.ArrayList;

public class MembreRecycleAdapter extends RecyclerView.Adapter<MembreRecycleAdapter.MyViewHolder> {
    private ArrayList<Membre> membres=null;
    private Context context;

    public MembreRecycleAdapter(ArrayList<Membre> membres, Context context) {
        this.membres = membres;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_personne_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.membre_name.setText(membres.get(position).getNOM_MEMBRE());
    }

    @Override
    public int getItemCount() {
        return membres.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView membre_name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            membre_name= itemView.findViewById(R.id.personne);
        }
    }
}
