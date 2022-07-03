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
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilearchive.models.StoreData;
import com.google.android.material.textview.MaterialTextView;

public class ProjetDetailsFragment extends Fragment {
    private Toolbar toolbar;
    private RecyclerView list_membres;
    private RecyclerView list_encadreurs;
    private MaterialTextView name_project;
    private MaterialTextView promotion_project;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_projet_details,container,false);
        toolbar= view.findViewById(R.id.top_toolbar);
        name_project= view.findViewById(R.id.details_projet_name);
        promotion_project= view.findViewById(R.id.details_projet_promotion);
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
    }
}
