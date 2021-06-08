package com.example.moonquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.moonquizz.model.utilisateurs;
import android.widget.RelativeLayout.LayoutParams;

import com.example.moonquizz.controler.controler;import java.util.ArrayList;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        init();
    }

    private controler controler;

    private void init(){
        this.controler= controler.getInstance(this);
        ArrayList<utilisateurs> listeUser ;
        listeUser= this.controler.recupListeUser();
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
            int id = controler.recupUser(prenom,nom).getId();
            joueur.setTag(id);
            //Ajout de la séparation

            TextView separation = new TextView(this);
            separation.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));



            layout.addView(joueur);
            layout.addView(separation);
        }
    }
}