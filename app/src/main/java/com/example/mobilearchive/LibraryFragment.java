package com.example.mobilearchive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilearchive.controllers.CategorieAdapter;
import com.example.mobilearchive.controllers.NavigationFragment;
import com.example.mobilearchive.models.Categorie;

import java.util.ArrayList;

public class LibraryFragment extends Fragment implements CategorieAdapter.gotoHome{
    private NavigationFragment navigationFragment;
    private RecyclerView categories_list;
    private ArrayList<Categorie> categories;
    private CategorieAdapter adapter;
    private Toolbar toolbar;

    public LibraryFragment(NavigationFragment navigationFragment) {
        this.navigationFragment = navigationFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getCategories();
        setAdapter();
        openNavigationLeft();
    }

    private void openNavigationLeft() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationFragment.openLeftNavigation();
            }
        });
    }

    private void getCategories(){
        categories.add(new Categorie(1,"Sante","Projet " +
                "lie a la sante",20));
        categories.add(new Categorie(1,"Sante","Projet " +
                "lie a la sante",20));
        categories.add(new Categorie(1,"Sante","Projet " +
                "lie a la sante",20));
        categories.add(new Categorie(1,"Sante","Projet " +
                "lie a la sante",20));
        categories.add(new Categorie(1,"Sante","Projet " +
                "lie a la sante",20));
    }
    private void setAdapter() {
        adapter= new CategorieAdapter(getContext(),categories,this::go);
        RecyclerView.LayoutManager manager= new LinearLayoutManager(getContext());
        categories_list.setLayoutManager(manager);
        categories_list.setAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_library, container, false);
        categories= new ArrayList<>();
        toolbar= view.findViewById(R.id.top_toolbar);
        categories_list= view.findViewById(R.id.categorie_list);
        toolbar.setTitle("Library");
        return view;
    }

    @Override
    public void go(Categorie categorie) {
        navigationFragment.categorieToHome();
    }
}