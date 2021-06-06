package com.example.moonquizz.model;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import com.example.moonquizz.outil.MySQLiteOpenHelper;

public class DAOBase{

        protected final static String NOM = "database.db";
        private int version=1;
        private MySQLiteOpenHelper accesDB;
        protected SQLiteDatabase Db = null;

        public  DAOBase(Context context){
            accesDB= new MySQLiteOpenHelper(context,NOM ,  null, version);
        }

        public SQLiteDatabase open(){
            Db= accesDB.getWritableDatabase();
            return Db;
        }

        public void close(){
            Db.close();
        }

        public SQLiteDatabase getDb(){
            return Db;
        }


    }


