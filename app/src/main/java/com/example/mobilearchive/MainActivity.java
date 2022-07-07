package com.example.mobilearchive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.mobilearchive.controllers.NavigationFragment;
import com.example.mobilearchive.models.Projet;
import com.example.mobilearchive.models.StoreData;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private BottomNavigationView navigationView;
    private NavigationView leftNavigationView;
    private NavigationFragment navigationFragment;
    private ShapeableImageView close_icon;
    private GestureDetector gestureDetector;
    private int x1;
    private int x2;
    static final int MIN_DISTANCE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigateBetweenProjectOption();
        this.gestureDetector= new GestureDetector(MainActivity.this,this);
        navigationView= findViewById(R.id.bottomNavigationView);
        leftNavigationView= findViewById(R.id.left_navigation);
        View header_view= leftNavigationView.getHeaderView(0);
        close_icon= header_view.findViewById(R.id.close_left_nav);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer,new HomeFragment(navigationFragment,null, null))
                .commit();
        close_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationFragment.closeLeftNavigation();
            }
        });
        leftNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return false;
            }
        });

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment=null;
                switch (item.getItemId()){
                    case R.id.homeFragment:
                        selectedFragment= new HomeFragment(navigationFragment);
                        break;
                    case R.id.libraryFragment:
                        selectedFragment= new LibraryFragment(navigationFragment);
                        break;
                    case R.id.profileFragment:
                        selectedFragment= new ProfileFragment(navigationFragment);
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

            @Override
            public void categorieToHome() {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer,new HomeFragment(navigationFragment,"Library",null))
                        .addToBackStack(null)
                        .commit();
            }

            @Override
            public void openLeftNavigation() {
                if (leftNavigationView.getVisibility()==View.GONE){
                    leftNavigationView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void closeLeftNavigation() {
                if (leftNavigationView.getVisibility()==View.VISIBLE){
                    leftNavigationView.setVisibility(View.GONE);
                }
            }
        };
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1= (int) event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2= (int) event.getX();

                float distance= x2-x1;
                if (Math.abs(distance) > MIN_DISTANCE && x1 > x2){
                    navigationFragment.closeLeftNavigation();
                }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}