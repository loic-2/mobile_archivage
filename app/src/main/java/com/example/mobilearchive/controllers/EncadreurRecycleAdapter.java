package com.example.mobilearchive.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilearchive.R;
import com.example.mobilearchive.models.Encadreur;

import java.util.ArrayList;

public class EncadreurRecycleAdapter extends RecyclerView.Adapter<EncadreurRecycleAdapter.MyViewHolder> {

    private ArrayList<Encadreur> encadreurs= null;
    private Context context;

    public EncadreurRecycleAdapter(ArrayList<Encadreur> encadreurs, Context context) {
        this.encadreurs = encadreurs;
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
        holder.encadreur_name.setText(encadreurs.get(position).getNOM_ENCADREUR());
    }

    @Override
    public int getItemCount() {
        return encadreurs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView encadreur_name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            encadreur_name=itemView.findViewById(R.id.personne);
        }
    }
}
