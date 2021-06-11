package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.moonquizz.controler.controller;
import com.example.moonquizz.model.utilisateurs;

import java.util.ArrayList;

public class SupprimerPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer_page);
        init();
        retour();
    }

    private controller controller;

    private void init(){
        this.controller = controller.getInstance(this);
        ArrayList<utilisateurs> listeUser ;
        listeUser= this.controller.recupListeUser();
        LinearLayout layout= findViewById(R.id.joueurs);
        for (int i=0; i<listeUser.size(); i++){
            //Récupération nom prénom
            String prenom =listeUser.get(i).getPrenom();
            String nom = listeUser.get(i).getNom();
            String prenomNom=prenom+" "+nom;

            //Création du bouton de suppression
            Button joueur= new Button(this);
            joueur.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
            joueur.setText(prenomNom);
            int id = listeUser.get(i).getId();
            joueur.setTag(id);


            //Ajout de la séparation

            TextView separation = new TextView(this);
            separation.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));



            layout.addView(joueur);
            layout.addView(separation);

            //Ajout de la fonction au bouton
            joueur.setOnClickListener(new  View.OnClickListener() {
                public void onClick(View v) {
                    controller.deleteUser(id);
                    Intent intent = new Intent(SupprimerPage.this,LoginPage.class);
                    startActivity(intent);
                }
            });
        }
    }

    private void retour(){
        findViewById(R.id.home).setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SupprimerPage.this,StartPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

}