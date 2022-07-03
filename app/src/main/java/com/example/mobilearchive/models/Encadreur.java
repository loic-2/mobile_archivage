package com.example.mobilearchive.models;

public class Encadreur {
    private int ID_ENCADREUR;
    private String NOM_ENCADREUR;
    private String PROFESSION_ENCADREUR;
    private String TELEPHONE_ENCADREUR;

    public Encadreur(int ID_ENCADREUR, String NOM_ENCADREUR, String PROFESSION_ENCADREUR, String TELEPHONE_ENCADREUR) {
        this.ID_ENCADREUR = ID_ENCADREUR;
        this.NOM_ENCADREUR = NOM_ENCADREUR;
        this.PROFESSION_ENCADREUR = PROFESSION_ENCADREUR;
        this.TELEPHONE_ENCADREUR = TELEPHONE_ENCADREUR;
    }

    public int getID_ENCADREUR() {
        return ID_ENCADREUR;
    }

    public void setID_ENCADREUR(int ID_ENCADREUR) {
        this.ID_ENCADREUR = ID_ENCADREUR;
    }

    public String getNOM_ENCADREUR() {
        return NOM_ENCADREUR;
    }

    public void setNOM_ENCADREUR(String NOM_ENCADREUR) {
        this.NOM_ENCADREUR = NOM_ENCADREUR;
    }

    public String getPROFESSION_ENCADREUR() {
        return PROFESSION_ENCADREUR;
    }

    public void setPROFESSION_ENCADREUR(String PROFESSION_ENCADREUR) {
        this.PROFESSION_ENCADREUR = PROFESSION_ENCADREUR;
    }

    public String getTELEPHONE_ENCADREUR() {
        return TELEPHONE_ENCADREUR;
    }

    public void setTELEPHONE_ENCADREUR(String TELEPHONE_ENCADREUR) {
        this.TELEPHONE_ENCADREUR = TELEPHONE_ENCADREUR;
    }
}
