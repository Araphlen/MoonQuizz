package com.example.moonquizz.model;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import com.example.moonquizz.outil.MySQLiteOpenHelper;

import java.util.ArrayList;

public class DAOBase{

        protected final static String NOM = "database.db";
        private int version=1;
        private MySQLiteOpenHelper accesDB;
        protected SQLiteDatabase db = null;

        public  DAOBase(Context context){
            accesDB= new MySQLiteOpenHelper(context,NOM ,  null, version);
        }


    public questions selectQuestion(int id){
            db=accesDB.getReadableDatabase();
        String req ="Select * from questions where id="+id;
        Cursor curseur=db.rawQuery(req, null);
        curseur.moveToFirst();
        String matiere= curseur.getString(1);
        int niveau = curseur.getInt(2);
        int num= curseur.getInt(3);
        String reponse= curseur.getString(4);
        String rep1= curseur.getString(5);
        if(niveau==2){
            String rep2= curseur.getString(6);
            String rep3= curseur.getString(7);
            curseur.close();
            questions quest= new questions(matiere,niveau, num,reponse,rep1,rep2,rep3,id);
            return quest;
        } else{
            curseur.close();
            questions quest= new questions(matiere,niveau, num,reponse,rep1,id);
            return quest;
        }
    }


    public String selectReponse(int id){
            db=accesDB.getReadableDatabase();
        String req ="Select * from questions where id="+id;
        Cursor curseur=db.rawQuery(req, null);
        curseur.moveToFirst();
        String reponse= curseur.getString(4);
        return  reponse;
    }

    public ArrayList selectQuestTheme(String matiere, int niveau){
        db=accesDB.getReadableDatabase();
        ArrayList tableau = new ArrayList();
        String req ="Select * from questions where matiere="+matiere+" and niveau="+niveau;
        Cursor curseur=db.rawQuery(req, null);
        for(curseur.moveToFirst(); !curseur.isAfterLast(); curseur.moveToNext()) {
            int num = curseur.getInt(3);
            String reponse = curseur.getString(4);
            String rep1 = curseur.getString(5);
            int id = curseur.getInt(8);
            if (niveau == 2) {
                String rep2 = curseur.getString(6);
                String rep3 = curseur.getString(7);
                questions quest = new questions(matiere, niveau, num, reponse, rep1, rep2, rep3, id);
                tableau.add(quest);

            } else {
                questions quest = new questions(matiere, niveau, num, reponse, rep1, id);
                tableau.add(quest);
            }
        } curseur.close();
        return tableau;
    }




    public void addUser(String prenom,String nom,String avatar){
            db=accesDB.getWritableDatabase();
        String req="insert into utilisateurs(prenom, nom, avatar) values ("+prenom+","+nom+","+avatar+")";
        db.execSQL(req);
    }

    public ArrayList selectUser(){
            db=accesDB.getReadableDatabase();
        ArrayList tableau = new ArrayList();
        String req ="Select * from utilisateurs";
        Cursor curseur=db.rawQuery(req, null);
        curseur.moveToFirst();
        for(curseur.moveToFirst(); !curseur.isAfterLast(); curseur.moveToNext()) {
            String prenom=curseur.getString(1);
            String nom=curseur.getString(2);
            String avatar= curseur.getString(3);
            int id=curseur.getInt(4);
            utilisateurs user=new utilisateurs(prenom, nom, avatar, id);
            tableau.add(user);

        }
        return tableau;
    }

    public boolean questValide(int idQuest, int idUser){
        db=accesDB.getReadableDatabase();
        String req="Select * from questionUtilisateurValidee where idQuestion="+idQuest+" and idUtilisateur="+idUser;
        Cursor curseur=db.rawQuery(req, null);
        curseur.moveToLast();
        if(curseur.isAfterLast()){
            return false;
        }else {
            return true;
        }
    }

    public void valideQuest(int idQuest, int idUser){
        db=accesDB.getWritableDatabase();
        String req="insert into questionUtilisateurValidee(idQuestion,idUtilisateur) values ("+idQuest+","+idUser+")";
        db.execSQL(req);
    }

    }


