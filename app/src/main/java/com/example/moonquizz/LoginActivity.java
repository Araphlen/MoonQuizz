package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.moonquizz.model.utilisateurs;
import android.widget.RelativeLayout.LayoutParams;

import com.example.moonquizz.controler.controller;import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        init();
        retour();
        supprimer();
    }

    private controller controller;

    private void init(){
        //On récupère le controller
        this.controller = controller.getInstance(this);
        ArrayList<utilisateurs> listeUser ;
        listeUser= this.controller.recupListeUser();
        LinearLayout layout= findViewById(R.id.joueurs);
        for (int i=0; i<listeUser.size(); i++){
            //Récupération nom prénom
            String prenom =listeUser.get(i).getPrenom();
            String nom = listeUser.get(i).getNom();
            String prenomNom=prenom+" "+nom;

            //Création du bouton de connexion
            Button joueur= new Button(this);
            joueur.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            joueur.setText(prenomNom);
            int id = listeUser.get(i).getId();
            joueur.setTag(id);


            //Ajout de la séparation

            TextView separation = new TextView(this);
            separation.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));



            layout.addView(joueur);
            layout.addView(separation);

            //Ajout de la fonction au bouton
            joueur.setOnClickListener(new  View.OnClickListener() {
                public void onClick(View v) {
                    //Selection de l'utilisateur actuel
                    controller.setCurrentUser(controller.recupUserByID(id));
                    Intent intent = new Intent(LoginActivity.this, ThemeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            });
        }
    }

    private void retour(){
        findViewById(R.id.home).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void supprimer(){
        findViewById(R.id.supprimer).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, DelUserActivity.class);
                startActivity(intent);
            }
        });
    }
}