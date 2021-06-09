package com.example.moonquizz.controler;

import android.service.controls.Control;
import android.content.Context;
import com.example.moonquizz.model.DAOBase;
import com.example.moonquizz.model.utilisateurs;

import java.util.ArrayList;

public final class controler {

    private static controler instance = null;
    private static DAOBase DAO;
    private static utilisateurs CurrentUser;
    private static String CurrentTheme;

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
}
