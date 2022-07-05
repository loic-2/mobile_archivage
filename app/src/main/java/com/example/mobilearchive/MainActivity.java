package com.example.mobilearchive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.mobilearchive.controllers.NavigationFragment;
import com.example.mobilearchive.models.Projet;
import com.example.mobilearchive.models.StoreData;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private NavigationFragment navigationFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigateBetweenProjectOption();
        navigationView= findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer,new HomeFragment(navigationFragment))
                .commit();
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment=null;
                System.out.println("***************************************"+item.getItemId()+"*******");
                switch (item.getItemId()){
                    case R.id.homeFragment:
                        selectedFragment= new HomeFragment(navigationFragment);
                        break;
                    case R.id.libraryFragment:
                        selectedFragment= new LibraryFragment();
                        break;
                    case R.id.profileFragment:
                        selectedFragment= new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer,selectedFragment)
                        .commit();
                return true;
            }
        });
    }

    private void navigateBetweenProjectOption() {
        navigationFragment= new NavigationFragment() {
            @Override
            public void studentDownload() {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer,new StudentPayementFragment(navigationFragment))
                        .addToBackStack(null)
                        .commit();
            }

            @Override
            public void payment() {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer,new ChoosePayementMethodFragment(navigationFragment))
                        .addToBackStack(null)
                        .commit();
            }

            @Override
            public void succesDownload() {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer,new HomeFragment(navigationFragment))
                        .commit();
            }

            @Override
            public void succesPayement() {

            }

            @Override
            public void go(Projet projet) {
                StoreData.projetItem =projet;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer,new ProjetDetailsFragment(navigationFragment))
                        .addToBackStack(null)
                        .commit();
            }
        };
    }

}