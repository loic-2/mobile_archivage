package com.example.mobilearchive.controllers;

import com.example.mobilearchive.models.Projet;

public interface NavigationFragment {
    void studentDownload();
    void payment();
    void succesDownload();
    void succesPayement();
    void go(Projet projet);
}
