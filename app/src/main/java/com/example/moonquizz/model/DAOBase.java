package com.example.moonquizz.model;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import com.example.moonquizz.outil.MySQLiteOpenHelper;

import java.util.ArrayList;

public class DAOBase{

        protected final static String NOM = "mobile.sqlite";
        private int version=1;
        private MySQLiteOpenHelper accesDB;
        protected SQLiteDatabase db = null;

        public  DAOBase(Context context){
            accesDB= new MySQLiteOpenHelper(context,NOM ,  null, version);
        }


        //Fonction liées à la table question

    //Vérifie s'il y a une autre question après dans le même niveau
    public boolean nextQuestion(String theme, int niveau, int num){
            int nump=num+1;
        String req ="Select * from questions where matiere="+"\""+theme+"\""+" and niveau="+niveau+" and num="+nump+";";
        Cursor curseur=db.rawQuery(req, null);
        curseur.moveToFirst();
        curseur.moveToLast();
        if(curseur.isAfterLast()){
            return false;
        }else {
            return true;
        }
    }

    //Récupère la question suivante
    public questions selectNextQuestion(String theme, int niveau, int num){
            db=accesDB.getReadableDatabase();
            int nump=num+1;
        String req ="Select * from questions where matiere="+"\""+theme+"\""+" and niveau="+niveau+" and num="+nump+";";
        Cursor curseur=db.rawQuery(req, null);
        curseur.moveToFirst();

        String question=curseur.getString(3);
        String reponse= curseur.getString(4);
        String rep1= curseur.getString(5);
        int id= curseur.getInt(8);
        //Vérifie si on doit récuperer toutes les reponses ou seulement 2
        if(niveau==2){
            String rep2= curseur.getString(6);
            String rep3= curseur.getString(7);
            curseur.close();
            questions quest= new questions(theme,niveau,num,question, reponse,rep1,rep2,rep3,id);
            return quest;
        } else{
            curseur.close();
            questions quest= new questions(theme,niveau,num,question, reponse,rep1,id);
            return quest;
        }
    }

    //Récupère la liste des réponse d'une question
    public ArrayList<String> selectReponse(int id){
            ArrayList<String > listRep= new ArrayList<String>();
            db=accesDB.getReadableDatabase();
        String req ="Select * from questions where id="+id+";";
        Cursor curseur=db.rawQuery(req, null);
        curseur.moveToFirst();
        int lvl= curseur.getInt(1);
        String reponse= curseur.getString(4);
        String rep1=curseur.getString(5);
        listRep.add(reponse);
        listRep.add(rep1);
        if(lvl==2){
            String rep2=curseur.getString(6);
            String rep3=curseur.getString(7);
            listRep.add(rep2);
            listRep.add(rep3);
        }

        return  listRep;
    }

    //Récupère la liste des questions liée à un thème et un niveau
    public ArrayList<questions> selectQuestTheme(String theme, int niveau){
        db=accesDB.getReadableDatabase();
        ArrayList<questions> tableau = new ArrayList();
        String req ="Select * from questions where matiere="+"\""+theme+"\""+" and niveau="+niveau+";";
        Cursor curseur=db.rawQuery(req, null);
        for(curseur.moveToFirst(); !curseur.isAfterLast(); curseur.moveToNext()) {
            int num = curseur.getInt(2);
            String question= curseur.getString(3);
            String reponse = curseur.getString(4);
            String rep1 = curseur.getString(5);
            int id = curseur.getInt(8);
            if (niveau == 2) {
                String rep2 = curseur.getString(6);
                String rep3 = curseur.getString(7   );
                questions quest = new questions(theme, niveau, num,question, reponse, rep1, rep2, rep3, id);
                tableau.add(quest);

            } else {
                questions quest = new questions(theme, niveau, num,question, reponse, rep1, id);
                tableau.add(quest);
            }
        } curseur.close();
        return tableau;
    }

    //Fonction liées à la table utlisateurs

    //Ajoute un utilisateur à la base
    public void addUser(String prenom,String nom,String avatar){
            db=accesDB.getWritableDatabase();
        //On vérifie si l'utilisateur n'est pas déjà dans la base
        String reqSelect ="Select * from utilisateurs where prenom="+"\""+prenom+"\""+" and nom="+"\""+nom+"\""+";";
        Cursor curseur=db.rawQuery(reqSelect, null);
        curseur.moveToLast();
        if(curseur.isAfterLast()){
            String req="insert into utilisateurs(prenom, nom, avatar) values ("+"\""+prenom+"\""+","+"\""+nom+"\""+","+"\""+avatar+"\""+")";
            try {
                db.execSQL(req);
              }catch (Exception e){
             }
        }
    }

    //Récupère la liste de tous les utilisateurs
    public ArrayList<utilisateurs> selectAllUser(){
            db=accesDB.getReadableDatabase();
        ArrayList tableau = new ArrayList();
        String req ="Select * from utilisateurs";
        Cursor curseur=db.rawQuery(req, null);
        for(curseur.moveToFirst(); !curseur.isAfterLast(); curseur.moveToNext()) {
            String prenom=curseur.getString(0);
            String nom=curseur.getString(1);
            String avatar=curseur.getString(2);
            int id=curseur.getInt(3);
            utilisateurs user=new utilisateurs(prenom, nom, avatar, id);
            tableau.add(user);

        }
        curseur.close();
        return tableau;
    }

    //Récupère un utilisateur en fonction de son nom et prénom
    public utilisateurs getUser(String prenom,String nom){
        db=accesDB.getReadableDatabase();
        String req="Select * from utilisateurs where prenom="+"\""+prenom+"\""+" and nom="+"\""+nom+"\""+";";
        Cursor curseur=db.rawQuery(req, null);
        curseur.moveToFirst();
        String avatar=curseur.getString(2);
        int id = curseur.getInt(3);
        utilisateurs user= new utilisateurs(prenom, nom, avatar, id);
        curseur.close();
        return user;
    }

    //Récupère un utilisateur en fonction de son
    public utilisateurs getUserByID(int id){
        db=accesDB.getReadableDatabase();
        String req="Select * from utilisateurs where id="+id+";";
        Cursor curseur=db.rawQuery(req, null);
        curseur.moveToFirst();
        String prenom= curseur.getString(0);
        String nom=curseur.getString(1);
        String avatar=curseur.getString(2);
        utilisateurs user= new utilisateurs(prenom, nom, avatar, id);
        curseur.close();
        return user;
    }

    //Supprime un Utilisateur de la base
    public void delUser(int id){
        db=accesDB.getWritableDatabase();
        String req="DELETE FROM utilisateurs WHERE id="+id+";";
        db.execSQL(req);
    }

    //Met à jour la colonne avatar d'un utilisateur
    public  void updateAvatar(int id , String avatar){
        db=accesDB.getWritableDatabase();
        String req="UPDATE utilisateurs SET avatar="+"\""+avatar+"\""+" WHERE id="+id+";";
        db.execSQL(req);
    }

    //Fonction liées à la table questionUtilisateurValidee

    //Vérifie si l'utilisateur à validé une question
    public boolean questValide(int idQuest, int idUser){
        db=accesDB.getReadableDatabase();
        String req="Select * from questionUtilisateurValidee where idQuestion="+idQuest+" and idUtilisateur="+idUser+";";
        Cursor curseur=db.rawQuery(req, null);
        curseur.moveToLast();
        if(curseur.isAfterLast()){
            return false;
        }else {
            return true;
        }
    }

    //Valide la question pour un utilisateur
    public void valideQuest(int idQuest, int idUser){
        db=accesDB.getWritableDatabase();
        String req="insert into questionUtilisateurValidee(idQuestion,idUtilisateur) values ("+idQuest+","+idUser+")";
        try{
            db.execSQL(req);
        } catch (Exception e){

        }

    }

    }


