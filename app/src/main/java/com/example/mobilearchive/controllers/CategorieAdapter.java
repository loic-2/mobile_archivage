package com.example.mobilearchive.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilearchive.R;
import com.example.mobilearchive.models.Categorie;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class CategorieAdapter extends RecyclerView.Adapter<CategorieAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Categorie> categories;
    private ArrayList<Categorie> all_categories;
    private gotoHome gotoHome;

    public CategorieAdapter(Context context, ArrayList<Categorie> categories,gotoHome gotoHome) {
        this.context = context;
        this.categories = categories;
        this.all_categories = categories;
        this.gotoHome=gotoHome;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.categorie_row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.categorie_image.setImageResource(R.drawable.books_on_table);
        holder.categorie_name.setText(all_categories.get(position).getNOM_CATEGORIE());
        holder.categorie_number_of_project.setText(" "+all_categories.get(position).getNOMBRE_PROJET()+"projets ");
        holder.main_layout_categorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               gotoHome.go(all_categories.get(position)
                .getCategorie());
            }
        });
    }

    @Override
    public int getItemCount() {
        return all_categories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private MaterialTextView categorie_name;
        private MaterialTextView categorie_number_of_project;
        private ShapeableImageView categorie_image;
        private ConstraintLayout main_layout_categorie;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            categorie_name= itemView.findViewById(R.id.nom_categorie);
            categorie_number_of_project= itemView.findViewById(R.id.nbre_projets_categorie);
            categorie_image= itemView.findViewById(R.id.image_categorie_item);
            main_layout_categorie= itemView.findViewById(R.id.main_layout_for_categorie);
        }
    }

    public interface gotoHome{
        void go(Categorie categorie);
    }
}
