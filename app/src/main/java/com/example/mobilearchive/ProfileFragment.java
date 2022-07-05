package com.example.mobilearchive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mobilearchive.controllers.ProfileNavigation;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
    private MaterialTextView username;
    private CircleImageView avatar;
    private Toolbar toolbar;
    private ProfileNavigation profileNavigation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        username= view.findViewById(R.id.username_profile);
        avatar= view.findViewById(R.id.avatar_image);
        toolbar= view.findViewById(R.id.top_toolbar);
        toolbar.setTitle("Profile");
        navigateBetweenProfileOption();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.profile_container,new ProfileActionFragment(profileNavigation))
                .commit();
        return view;
    }

    private void navigateBetweenProfileOption() {
        profileNavigation= new ProfileNavigation() {
            @Override
            public void downloads() {

            }

            @Override
            public void archives() {

            }

            @Override
            public void tellFriend() {

            }

            @Override
            public void favourites() {

            }

            @Override
            public void help() {

            }

            @Override
            public void settings() {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.profile_container,new SettingsFragment())
                        .addToBackStack(null)
                        .commit();
            }
        };
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}