package com.example.mobilearchive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.mobilearchive.controllers.NavigationFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class StudentPayementFragment extends Fragment {
    private NavigationFragment navigationFragment;
    private TextInputLayout username;
    private TextInputLayout matricule;
    private TextInputLayout password;
    private MaterialButton download;
    private Toolbar toolbar;

    public StudentPayementFragment(NavigationFragment navigationFragment) {
        this.navigationFragment= navigationFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.student_download_fragment,container,false);
        toolbar= view.findViewById(R.id.top_toolbar);
        username= view.findViewById(R.id.username_student_download);
        matricule= view.findViewById(R.id.matricule_student_download);
        password= view.findViewById(R.id.password_student_download);
        download= view.findViewById(R.id.download_btn_student);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.back_arrow));
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationFragment.succesDownload();
            }
        });
    }
}
