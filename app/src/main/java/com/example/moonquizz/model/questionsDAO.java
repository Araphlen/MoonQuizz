package com.example.moonquizz.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class questionsDAO {
    public static final String TABLE_NAME= "questions";
    public static final String KEY="id";
    public static final String MATIERE="matiere";
    public static final String NIVEAU="niveau";
    public static final String NUM="num";
    public static final String REPONSE="reponse";
    public static final String REP1="rep1";
    public static final String REP2="rep2";
    public static final String REP3="rep3";
    public static DAOBase DAO;
    public static SQLiteDatabase db;

    public questionsDAO(Context context){
        DAO=new DAOBase(context);
        db=DAO.getDb();
    }



    public questions selectionnerUne(int id){

        DAO.open();
        String req ="Select * from questions where id="+id;
        Cursor curseur=db.rawQuery(req, null);
        curseur.moveToFirst();
        String matiere= curseur.getString(1);
        int niveau = curseur.getInt(2);
        int num= curseur.getInt(3);
        String reponse= curseur.getString(4);
        String rep1= curseur.getString(5);
        if(niveau>4){
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
}
