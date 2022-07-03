package com.example.mobilearchive.models;

public class Membre {
    private int ID_MEMBRE;
    private String NOM_MEMBRE;
    private String TELEPHONE_MEMBRE;
    private String FILIERE_MEMBRE;

    public Membre(int ID_MEMBRE, String NOM_MEMBRE, String TELEPHONE_MEMBRE, String FILIERE_MEMBRE) {
        this.ID_MEMBRE = ID_MEMBRE;
        this.NOM_MEMBRE = NOM_MEMBRE;
        this.TELEPHONE_MEMBRE = TELEPHONE_MEMBRE;
        this.FILIERE_MEMBRE = FILIERE_MEMBRE;
    }

    public int getID_MEMBRE() {
        return ID_MEMBRE;
    }

    public void setID_MEMBRE(int ID_MEMBRE) {
        this.ID_MEMBRE = ID_MEMBRE;
    }

    public String getNOM_MEMBRE() {
        return NOM_MEMBRE;
    }

    public void setNOM_MEMBRE(String NOM_MEMBRE) {
        this.NOM_MEMBRE = NOM_MEMBRE;
    }

    public String getTELEPHONE_MEMBRE() {
        return TELEPHONE_MEMBRE;
    }

    public void setTELEPHONE_MEMBRE(String TELEPHONE_MEMBRE) {
        this.TELEPHONE_MEMBRE = TELEPHONE_MEMBRE;
    }

    public String getFILIERE_MEMBRE() {
        return FILIERE_MEMBRE;
    }

    public void setFILIERE_MEMBRE(String FILIERE_MEMBRE) {
        this.FILIERE_MEMBRE = FILIERE_MEMBRE;
    }
}
