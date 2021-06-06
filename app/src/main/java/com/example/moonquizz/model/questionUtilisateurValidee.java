package com.example.moonquizz.model;

public class questionUtilisateurValidee {
    private int idQuestion;
    private int idUtilisateur;

    public questionUtilisateurValidee(int idQuestion, int idUtilisateur) {
        this.idQuestion = idQuestion;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
