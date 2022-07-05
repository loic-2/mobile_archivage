package com.example.mobilearchive.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilearchive.R;
import com.example.mobilearchive.models.Projet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class ProjetRecycleAdapter extends RecyclerView.Adapter<ProjetRecycleAdapter.MyViewHolder> implements Filterable {

    private ArrayList<Projet> projetList= new ArrayList<>();
    private ArrayList<Projet> allProjetList= new ArrayList<>();
    private gotoDetails navigation;
    public Context context;

    public ProjetRecycleAdapter(Context context, ArrayList<Projet> projetArrayList, gotoDetails navigation) {
        this.context=context;
        this.projetList=projetArrayList;
        this.allProjetList=projetArrayList;
        this.navigation= navigation;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.projet_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nom_projet.setText(projetList.get(position).getNOM_PROJET());
        holder.promotion_projet.setText(projetList.get(position).getPROMOTION_PROJET());
        holder.vue_projet.setText(projetList.get(position).getVUE_PROJET());
        holder.telechargement_projet.setText(projetList.get(position).getTELECHARGEMENT_PROJET());
        holder.image_projet.setImageResource(R.drawable.books_on_table);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigation.go(projetList.get(position).getProjet().getProjet());
            }
        });

    }


    @Override
    public int getItemCount() {
        return this.projetList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nom_projet;
        private TextView promotion_projet;
        private TextView vue_projet;
        private TextView telechargement_projet;
        private ImageView image_projet;
        private LinearLayout row_action;
        private ConstraintLayout constraintLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nom_projet= itemView.findViewById(R.id.project_name);
            promotion_projet= itemView.findViewById(R.id.project_promotion);
            vue_projet= itemView.findViewById(R.id.nbre_vue);
            telechargement_projet= itemView.findViewById(R.id.nbre_tele);
            image_projet= itemView.findViewById(R.id.image_projet);
            row_action= itemView.findViewById(R.id.row_btn_action);
            constraintLayout= itemView.findViewById(R.id.projet_item);
        }
    }

    private Filter filter= new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<Projet> filterListProjet= new ArrayList<>();
            if (charSequence.toString().isEmpty()){
                filterListProjet.addAll(allProjetList);
            }else {
                for (Projet projet:allProjetList){
                    if (projet.getNOM_PROJET().toLowerCase(Locale.ROOT)
                            .contains(charSequence.toString().toLowerCase(Locale.ROOT))){
                        filterListProjet.add(projet);
                    }else {
                        if (projet.getPROMOTION_PROJET().toLowerCase(Locale.ROOT)
                                .contains(charSequence.toString().toLowerCase(Locale.ROOT))){
                            filterListProjet.add(projet);
                        }
                    }
                }
            }

            FilterResults filterResults= new FilterResults();
            filterResults.values=filterListProjet;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            projetList.clear();
            projetList.addAll((Collection<? extends Projet>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public interface gotoDetails{
        void go(Projet projet);
    }
}
