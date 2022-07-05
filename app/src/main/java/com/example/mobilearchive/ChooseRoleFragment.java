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

public class ChooseRoleFragment extends Fragment {
    FragmentAuthenticate fragmentAuthenticate;
    private MaterialButton btn_student;
    private MaterialButton btn_others;

    public ChooseRoleFragment(FragmentAuthenticate fragmentAuthenticate) {
        this.fragmentAuthenticate = fragmentAuthenticate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_choise,container,false);
        btn_student= view.findViewById(R.id.btn_student);
        btn_others= view.findViewById(R.id.btn_other);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentAuthenticate.student();
            }
        });
        btn_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentAuthenticate.others();
            }
        });
    }
}
