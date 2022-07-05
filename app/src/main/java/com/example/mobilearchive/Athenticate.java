package com.example.mobilearchive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mobilearchive.controllers.FragmentAuthenticate;

public class Athenticate extends AppCompatActivity{
    private FragmentAuthenticate fragmentAuthenticate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athenticate);
        navigate();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.authenticate_container,new ConnexionFragment(fragmentAuthenticate))
                .commit();
    }

    private void navigate() {
        fragmentAuthenticate= new FragmentAuthenticate() {
            @Override
            public void loginSucces() {
                Intent intent= new Intent(Athenticate.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void registerHere() {
                getSupportFragmentManager().beginTransaction().replace(R.id.authenticate_container, new ChooseRoleFragment(fragmentAuthenticate))
                        .addToBackStack(null)
                        .commit();
            }

            @Override
            public void signUpWithGoogle() {

            }

            @Override
            public void succesSignIn() {
                getSupportFragmentManager().beginTransaction().replace(R.id.authenticate_container, new ConnexionFragment(fragmentAuthenticate))
                        .addToBackStack(null)
                        .commit();
            }

            @Override
            public void student() {
                getSupportFragmentManager().beginTransaction().replace(R.id.authenticate_container, new InscriptionFragment(fragmentAuthenticate))
                        .addToBackStack(null)
                        .commit();
            }

            @Override
            public void others() {

            }

            @Override
            public void forgotPassword() {

            }

            @Override
            public void back() {
                onBackPressed();
            }
        };
    }
}