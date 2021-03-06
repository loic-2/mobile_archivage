package com.example.mobilearchive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilearchive.controllers.EncadreurRecycleAdapter;
import com.example.mobilearchive.controllers.MembreRecycleAdapter;
import com.example.mobilearchive.controllers.NavigationFragment;
import com.example.mobilearchive.models.Encadreur;
import com.example.mobilearchive.models.Membre;
import com.example.mobilearchive.models.StoreData;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class ProjetDetailsFragment extends Fragment {
    private Toolbar toolbar;
    private RecyclerView list_membres;
    private RecyclerView list_encadreurs;
    private MaterialTextView name_project;
    private MaterialTextView promotion_project;
    private ArrayList<Encadreur> encadreurs;
    private ArrayList<Membre> membres;
    private MaterialButton btn_download;
    private MaterialButton btn_archive;
    private MaterialButton btn_add_to_favour;
    private MaterialButton btn_read;
    private NavigationFragment navigationFragment;

    public ProjetDetailsFragment(NavigationFragment navigationFragment) {
        this.navigationFragment = navigationFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_projet_details,container,false);
        toolbar= view.findViewById(R.id.top_toolbar);
        name_project= view.findViewById(R.id.details_projet_name);
        promotion_project= view.findViewById(R.id.details_projet_promotion);
        list_encadreurs= view.findViewById(R.id.list_encadreurs);
        list_membres= view.findViewById(R.id.list_membre);
        btn_add_to_favour= view.findViewById(R.id.add_project_to_favour);
        btn_archive= view.findViewById(R.id.archive_project);
        btn_download= view.findViewById(R.id.download_project);
        btn_read= view.findViewById(R.id.read_project);
        encadreurs= new ArrayList<>();
        membres= new ArrayList<>();
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.back_arrow));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        toolbar.setTitle("Details");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name_project.setText(StoreData.projetItem.getNOM_PROJET());
        promotion_project.setText(StoreData.projetItem.getPROMOTION_PROJET());
        navigateToOption();
        getAllMembres();
        getAllEncadreurs();
        setCustomAdapter();
    }

    private void navigateToOption() {
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationFragment.studentDownload();
            }
        });
    }

    private void setCustomAdapter(){
        EncadreurRecycleAdapter encadreurRecycleAdapter= new EncadreurRecycleAdapter(encadreurs,getContext());
        MembreRecycleAdapter membreRecycleAdapter= new MembreRecycleAdapter(membres,getContext());
        RecyclerView.LayoutManager manager= new LinearLayoutManager(getContext());
        list_membres.setLayoutManager(manager);
        list_membres.setAdapter(membreRecycleAdapter);
        RecyclerView.LayoutManager manager2= new LinearLayoutManager(getContext());
        list_encadreurs.setLayoutManager(manager2);
        list_encadreurs.setAdapter(encadreurRecycleAdapter);
    }

    private void getAllEncadreurs(){
        encadreurs.add(new Encadreur(1,"Fogang Aristide",
                "Ing","653445669"));
        encadreurs.add(new Encadreur(2,"Abouem Kevin",
                "Ing","654237814"));
    }

    private void getAllMembres() {
        membres.add(new Membre(1,"Ganno Loic","655084085"
        ,"ITT3-IR"));
        membres.add(new Membre(2,"Tekonnang Brian","655344085"
                ,"ITT3-IR"));
        membres.add(new Membre(3,"Irma Ahena","678954555"
                ,"ITT3-IR"));
        membres.add(new Membre(4,"Naeke Hannah","673765643"
                ,"IPT-CT"));
        membres.add(new Membre(5,"Ndi Leslie","652345685"
                ,"IPT-MGT"));
    }
}
