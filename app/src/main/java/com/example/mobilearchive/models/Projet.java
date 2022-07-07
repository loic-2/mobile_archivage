package com.example.mobilearchive.models;

public class Projet {
    private String NOM_PROJET;
    private String PROMOTION_PROJET;
    private String VUE_PROJET;
    private String TELECHARGEMENT_PROJET;
    private String LIEN_PROJET;
    private int ID_PROJET;
    private String TYPE_PROJET;
    private String created_at;
    private String updated_at;

    public Projet(String NOM_PROJET, String PROMOTION_PROJET, String VUE_PROJET, String TELECHARGEMENT_PROJET, String LIEN_PROJET,
                  int ID_PROJET, String TYPE_PROJET, String created_at, String updated_at)
    {
        this.NOM_PROJET = NOM_PROJET;
        this.PROMOTION_PROJET = PROMOTION_PROJET;
        this.VUE_PROJET = VUE_PROJET;
        this.TELECHARGEMENT_PROJET = TELECHARGEMENT_PROJET;
        this.LIEN_PROJET = LIEN_PROJET;
        this.ID_PROJET = ID_PROJET;
        this.TYPE_PROJET = TYPE_PROJET;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Projet(String NOM_PROJET, String PROMOTION_PROJET, String VUE_PROJET, String TELECHARGEMENT_PROJET, String LIEN_PROJET, int ID_PROJET, String TYPE_PROJET) {
        this.NOM_PROJET = NOM_PROJET;
        this.PROMOTION_PROJET = PROMOTION_PROJET;
        this.VUE_PROJET = VUE_PROJET;
        this.TELECHARGEMENT_PROJET = TELECHARGEMENT_PROJET;
        this.LIEN_PROJET = LIEN_PROJET;
        this.ID_PROJET = ID_PROJET;
        this.TYPE_PROJET = TYPE_PROJET;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Projet getProjet(){
        return this;
    }

    public String getNOM_PROJET() {
        return NOM_PROJET;
    }

    public void setNOM_PROJET(String NOM_PROJET) {
        this.NOM_PROJET = NOM_PROJET;
    }

    public String getPROMOTION_PROJET() {
        return PROMOTION_PROJET;
    }

    public void setPROMOTION_PROJET(String PROMOTION_PROJET) {
        this.PROMOTION_PROJET = PROMOTION_PROJET;
    }

    public String getVUE_PROJET() {
        return VUE_PROJET;
    }

    public void setVUE_PROJET(String VUE_PROJET) {
        this.VUE_PROJET = VUE_PROJET;
    }

    public String getTELECHARGEMENT_PROJET() {
        return TELECHARGEMENT_PROJET;
    }

    public void setTELECHARGEMENT_PROJET(String TELECHARGEMENT_PROJET) {
        this.TELECHARGEMENT_PROJET = TELECHARGEMENT_PROJET;
    }

    public String getLIEN_PROJET() {
        return LIEN_PROJET;
    }

    public void setLIEN_PROJET(String LIEN_PROJET) {
        this.LIEN_PROJET = LIEN_PROJET;
    }

    public int getID_PROJET() {
        return ID_PROJET;
    }

    public void setID_PROJET(int ID_PROJET) {
        this.ID_PROJET = ID_PROJET;
    }

    public String getTYPE_PROJET() {
        return TYPE_PROJET;
    }

    public void setTYPE_PROJET(String TYPE_PROJET) {
        this.TYPE_PROJET = TYPE_PROJET;
    }
}
