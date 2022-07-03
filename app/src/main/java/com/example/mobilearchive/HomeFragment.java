package com.example.mobilearchive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilearchive.controllers.ProjetRecycleAdapter;
import com.example.mobilearchive.models.Projet;
import com.example.mobilearchive.models.StoreData;

import java.util.ArrayList;

 public class HomeFragment extends Fragment implements ProjetRecycleAdapter.gotoDetails{
    private ArrayList<Projet> projetArrayList;
    public RecyclerView recyclerView;
    private Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home,container,false);
        projetArrayList= new ArrayList<>();
        toolbar= view.findViewById(R.id.top_toolbar);
        toolbar.setTitle("Home");
        recyclerView= view.findViewById(R.id.homelist);
        getAllRemoteProjet();
        setAdapter();
        return view;
    }

    private void getAllRemoteProjet() {
        projetArrayList.add(new Projet("PROJET TEST", "2019-2022", "3", "4",
                "http://localhost/api/projet",'4', "PFE"));
        projetArrayList.add(new Projet("PROJET TEST", "2018-2021", "3", "4",
                "http://localhost/api/projet",'4', "PFE"));
        projetArrayList.add(new Projet("PROJET TEST", "2017-2020", "3", "4",
                "http://localhost/api/projet",'4', "PFE"));
        projetArrayList.add(new Projet("PROJET TEST", "2016-2019", "3", "4",
                "http://localhost/api/projet",'4', "PFE"));
        projetArrayList.add(new Projet("PROJET TEST", "2015-2018", "3", "4",
                "http://localhost/api/projet",'4', "PFE"));
        projetArrayList.add(new Projet("PROJET TEST", "2014-2017", "3", "4",
                "http://localhost/api/projet",'4', "PFE"));
    }

    private void setAdapter() {
        ProjetRecycleAdapter adapter= new ProjetRecycleAdapter(getContext(),projetArrayList,this::go);
        RecyclerView.LayoutManager manager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

     @Override
     public void go(Projet projet) {
        StoreData.projetItem =projet;
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer,new ProjetDetailsFragment())
                .addToBackStack(null)
                .commit();
     }
 }