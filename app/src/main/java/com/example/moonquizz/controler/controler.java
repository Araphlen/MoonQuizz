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
        CurrentUser= DAO.getUser(prenom,nom);
    }

    public utilisateurs recupUser(String prenom, String nom){
        return DAO.getUser(prenom,nom);
    }

    public ArrayList<utilisateurs> recupListeUser(){
        return DAO.selectUser();
    }


}
