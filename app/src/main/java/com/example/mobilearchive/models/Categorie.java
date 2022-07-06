package com.example.mobilearchive.models;

public class Categorie {
    private int ID_CATEGORIE;
    private String NOM_CATEGORIE;
    private String DESCRIPTION_CATEGORIE;
    private int NOMBRE_PROJET;

    public Categorie(int ID_CATEGORIE, String NOM_CATEGORIE, String DESCRIPTION_CATEGORIE, int NOMBRE_PROJET) {
        this.ID_CATEGORIE = ID_CATEGORIE;
        this.NOM_CATEGORIE = NOM_CATEGORIE;
        this.DESCRIPTION_CATEGORIE = DESCRIPTION_CATEGORIE;
        this.NOMBRE_PROJET = NOMBRE_PROJET;
    }

    public Categorie(int ID_CATEGORIE, String NOM_CATEGORIE, String DESCRIPTION_CATEGORIE) {
        this.ID_CATEGORIE = ID_CATEGORIE;
        this.NOM_CATEGORIE = NOM_CATEGORIE;
        this.DESCRIPTION_CATEGORIE = DESCRIPTION_CATEGORIE;
    }

    public int getNOMBRE_PROJET() {
        return NOMBRE_PROJET;
    }

    public void setNOMBRE_PROJET(int NOMBRE_PROJET) {
        this.NOMBRE_PROJET = NOMBRE_PROJET;
    }

    public Categorie getCategorie(){
        return this;
    }

    public int getID_CATEGORIE() {
        return ID_CATEGORIE;
    }

    public void setID_CATEGORIE(int ID_CATEGORIE) {
        this.ID_CATEGORIE = ID_CATEGORIE;
    }

    public String getNOM_CATEGORIE() {
        return NOM_CATEGORIE;
    }

    public void setNOM_CATEGORIE(String NOM_CATEGORIE) {
        this.NOM_CATEGORIE = NOM_CATEGORIE;
    }

    public String getDESCRIPTION_CATEGORIE() {
        return DESCRIPTION_CATEGORIE;
    }

    public void setDESCRIPTION_CATEGORIE(String DESCRIPTION_CATEGORIE) {
        this.DESCRIPTION_CATEGORIE = DESCRIPTION_CATEGORIE;
    }
}
