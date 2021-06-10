package com.example.moonquizz.controler;

import android.service.controls.Control;
import android.content.Context;
import com.example.moonquizz.model.DAOBase;
import com.example.moonquizz.model.questions;
import com.example.moonquizz.model.utilisateurs;

import java.util.ArrayList;

public final class controler {

    private static controler instance = null;
    private static DAOBase DAO;
    private static utilisateurs CurrentUser;
    private static String CurrentTheme;
    private static int CurrentLvl;
    private static  questions CurrentQuest;

    public static utilisateurs getCurrentUser() {
        return CurrentUser;
    }

    public static void setCurrentUser(utilisateurs currentUser) {
        CurrentUser = currentUser;
    }

    public static String getCurrentTheme() {
        return CurrentTheme;
    }

    public static void setCurrentTheme(String currentTheme) {
        CurrentTheme = currentTheme;
    }

    public static int getCurrentLvl() {
        return CurrentLvl;
    }

    public static void setCurrentLvl(int currentLvl) {
        CurrentLvl = currentLvl;
    }

    public static questions getCurrentQuest() {
        return CurrentQuest;
    }

    public static void setCurrentQuest(questions currentQuest) {
        CurrentQuest = currentQuest;
    }

    private controler(){
        super();
    }

    public static  final controler getInstance(Context context){
        if(controler.instance == null){
            controler.instance= new controler();
            DAO= new DAOBase(context);
        }
        return controler.instance;
    }

    public void ajoutUtilisateur(String prenom, String nom, String avatar){
        DAO.addUser(prenom, nom, avatar);
        setCurrentUser( DAO.getUser(prenom,nom));
    }

    public utilisateurs recupUser(String prenom, String nom){

        return DAO.getUser(prenom,nom);
    }

    public utilisateurs recupUserByID(int id){
        return  DAO.getUserByID(id);
    }

    public ArrayList<utilisateurs> recupListeUser(){
        return DAO.selectUser();
    }

    public void deleteUser(int id){
        DAO.delUser(id);
    }

    public void changeAvatar(String avatar){
        CurrentUser.setAvatar(avatar);
        int id = CurrentUser.getId();
        DAO.updateAvatar(id, avatar);
    }


    public ArrayList<questions> recupListeQuest(){
        return  DAO.selectQuestTheme(CurrentTheme,CurrentLvl);
    }

    public ArrayList<String> recupListeRep(){
        return DAO.selectReponse(CurrentQuest.getId());
    }

    public boolean verifQuest(int idQuest, int idUser){
        return  DAO.questValide(idQuest,idUser);
    }

    public void valideQuest(){
        DAO.valideQuest(CurrentQuest.getId(),CurrentQuest.getId());
    }
}