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
import com.google.android.material.textview.MaterialTextView;

public class ConnexionFragment extends Fragment {
    private MaterialButton btn_connexion;
    private MaterialTextView register_text;
    private MaterialTextView forgot_password;
    private FragmentAuthenticate fragmentAuthenticate;

    public ConnexionFragment(FragmentAuthenticate fragmentAuthenticate) {
        this.fragmentAuthenticate = fragmentAuthenticate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= LayoutInflater.from(getContext()).inflate(R.layout.fragment_connexion,container,false);
        btn_connexion= view.findViewById(R.id.btn_login);
        register_text= view.findViewById(R.id.register_text);
        forgot_password= view.findViewById(R.id.forgot_text);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        register_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentAuthenticate.registerHere();
            }
        });
        btn_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentAuthenticate.loginSucces();
            }
        });
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentAuthenticate.forgotPassword();
            }
        });
    }
}
