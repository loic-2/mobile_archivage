package com.example.mobilearchive.models;

public class Utilisateur {
    public Utilisateur(String NOM_UTILISATEUR, String EMAIL_UTILISATEUR, String MATRICULE_UTILISATEUR, String LOGIN_UTILISATEUR, String MOT_DE_PASSE_UTILISATEUR, int ID_UTILISATEUR) {
        this.NOM_UTILISATEUR = NOM_UTILISATEUR;
        this.EMAIL_UTILISATEUR = EMAIL_UTILISATEUR;
        this.MATRICULE_UTILISATEUR = MATRICULE_UTILISATEUR;
        this.LOGIN_UTILISATEUR = LOGIN_UTILISATEUR;
        this.MOT_DE_PASSE_UTILISATEUR = MOT_DE_PASSE_UTILISATEUR;
        this.ID_UTILISATEUR = ID_UTILISATEUR;
    }

    public Utilisateur getUtilisateur(){
        return this;
    }

    public String getNOM_UTILISATEUR() {
        return NOM_UTILISATEUR;
    }

    public void setNOM_UTILISATEUR(String NOM_UTILISATEUR) {
        this.NOM_UTILISATEUR = NOM_UTILISATEUR;
    }

    public String getEMAIL_UTILISATEUR() {
        return EMAIL_UTILISATEUR;
    }

    public void setEMAIL_UTILISATEUR(String EMAIL_UTILISATEUR) {
        this.EMAIL_UTILISATEUR = EMAIL_UTILISATEUR;
    }

    public String getMATRICULE_UTILISATEUR() {
        return MATRICULE_UTILISATEUR;
    }

    public void setMATRICULE_UTILISATEUR(String MATRICULE_UTILISATEUR) {
        this.MATRICULE_UTILISATEUR = MATRICULE_UTILISATEUR;
    }

    public String getLOGIN_UTILISATEUR() {
        return LOGIN_UTILISATEUR;
    }

    public void setLOGIN_UTILISATEUR(String LOGIN_UTILISATEUR) {
        this.LOGIN_UTILISATEUR = LOGIN_UTILISATEUR;
    }

    public String getMOT_DE_PASSE_UTILISATEUR() {
        return MOT_DE_PASSE_UTILISATEUR;
    }

    public void setMOT_DE_PASSE_UTILISATEUR(String MOT_DE_PASSE_UTILISATEUR) {
        this.MOT_DE_PASSE_UTILISATEUR = MOT_DE_PASSE_UTILISATEUR;
    }

    public int getID_UTILISATEUR() {
        return ID_UTILISATEUR;
    }

    public void setID_UTILISATEUR(int ID_UTILISATEUR) {
        this.ID_UTILISATEUR = ID_UTILISATEUR;
    }

    private String NOM_UTILISATEUR;
    private String EMAIL_UTILISATEUR;
    private String MATRICULE_UTILISATEUR;
    private String LOGIN_UTILISATEUR;
    private String MOT_DE_PASSE_UTILISATEUR;
    private int ID_UTILISATEUR;
}
