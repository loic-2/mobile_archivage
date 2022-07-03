package com.example.mobilearchive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView= findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer,new HomeFragment())
                .commit();
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment=null;
                System.out.println("***************************************"+item.getItemId()+"*******");
                switch (item.getItemId()){
                    case R.id.homeFragment:
                        selectedFragment= new HomeFragment();
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

}