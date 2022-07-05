package com.example.mobilearchive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mobilearchive.controllers.ProfileNavigation;
import com.google.android.material.textview.MaterialTextView;

public class ProfileActionFragment extends Fragment {
    private ProfileNavigation profileNavigation;
    private MaterialTextView downloads;
    private MaterialTextView archives;
    private MaterialTextView favourites;
    private MaterialTextView help;
    private MaterialTextView settings;
    private MaterialTextView tell_a_friend;

    public ProfileActionFragment(ProfileNavigation profileNavigation) {
        this.profileNavigation = profileNavigation;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile_action,container,false);
        settings= view.findViewById(R.id.profile_settings);
        downloads= view.findViewById(R.id.profile_downloads);
        archives= view.findViewById(R.id.profile_archives);
        favourites= view.findViewById(R.id.profile_favourites);
        help= view.findViewById(R.id.profile_help);
        tell_a_friend= view.findViewById(R.id.profile_tell_friend);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileNavigation.settings();
            }
        });
    }
}
