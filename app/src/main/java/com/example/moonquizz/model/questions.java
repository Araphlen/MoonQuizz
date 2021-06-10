package com.example.moonquizz.model;

public class questions {
    private String matiere;
    private int niveau;
    private int num;
    private String question;
    private String reponse;
    private String rep1;
    private String rep2;
    private String rep3;
    private  int id;


    public questions(String matiere, int niveau, int num,String question, String reponse, String rep1, String rep2, String rep3, int id) {
        this.matiere = matiere;
        this.niveau = niveau;
        this.num = num;
        this.question=question;
        this.reponse = reponse;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.rep3 = rep3;
        this.id=id;
    }

    public questions(String matiere, int niveau, int num,String question, String reponse, String rep1,int id) {
        this.matiere = matiere;
        this.niveau = niveau;
        this.num = num;
        this.question=question;
        this.reponse = reponse;
        this.rep1 = rep1;
        this.id=id;
    }

    public String getMatiere() {
        return matiere;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getNum() {
        return num;
    }

    public String getReponse() {
        return reponse;
    }

    public String getRep1() {
        return rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public String getRep3() {
        return rep3;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }

    public void setRep3(String rep3) {
        this.rep3 = rep3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
