package com.example.mobilearchive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mobilearchive.controllers.FragmentAuthenticate;
import com.google.android.material.button.MaterialButton;

public class InscriptionFragment extends Fragment {
    FragmentAuthenticate fragmentAuthenticate;
    private MaterialButton btn_inscription;

    public InscriptionFragment(FragmentAuthenticate fragmentAuthenticate) {
        this.fragmentAuthenticate = fragmentAuthenticate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_inscription,container,false);
        btn_inscription= view.findViewById(R.id.btn_signin);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentAuthenticate.succesSignIn();
            }
        });
    }
}
