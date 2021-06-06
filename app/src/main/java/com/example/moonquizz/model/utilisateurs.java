package com.example.moonquizz.model;

public class utilisateurs {
    private String prenom;
    private String nom;
    private String avatar;
    private int id;



    public utilisateurs(String prenom, String nom, String avatar, int id){
        super();
        this.prenom=prenom;
        this.nom=nom;
        this.avatar=avatar;
        this.id=id;
    }

    public String getPrenom(){
        return prenom;
    }

    public String getNom(){
        return nom;
    }

    public String getAvatar(){
        return avatar;
    }

    public int getId(){
        return id;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
