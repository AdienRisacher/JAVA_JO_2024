package com.example.java_jo_2024;

public class User {
    private String nom;
    private String email;
    private String mdp;
    private int id;

    public User(String nom, String email, String mdp, int id) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.id = id;
    }

    public String getNom() {

        return nom;
    }

    public String getMdp(){
        return mdp;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}
